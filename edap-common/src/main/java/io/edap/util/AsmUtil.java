/*
 * Copyright 2020 The edap Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.edap.util;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import static org.objectweb.asm.Opcodes.*;


public class AsmUtil {

    private AsmUtil() {}

    public static boolean isArray(Type type) {
        if (type instanceof Class) {
            Class arrayCls = (Class)type;
            return arrayCls.isArray() && !"[B".equals(arrayCls.getName());
        }
        return false;
    }

    public static void visitIntInsn(int value, MethodVisitor mv) {
        if (value == 0) {
            mv.visitInsn(ICONST_0);
        }else if (value == 1) {
            mv.visitInsn(ICONST_1);
        } else if (value == 2) {
            mv.visitInsn(ICONST_2);
        } else if (value == 3) {
            mv.visitInsn(ICONST_3);
        } else if (value == 4) {
            mv.visitInsn(ICONST_4);
        } else if (value == 5) {
            mv.visitInsn(ICONST_5);
        } else if (value < Byte.MAX_VALUE) {
            mv.visitIntInsn(BIPUSH, value);
        }
    }

    public static boolean isPojo(Type type) {
        if (type == null) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            return false;
        }
        Class tClass = (Class)type;
        if (tClass.isPrimitive()) {
            return false;
        }
        if (tClass.isEnum()) {
            return false;
        }
        if (tClass.isArray()) {
            return false;
        }
        return !tClass.getName().startsWith("java.")
                && !tClass.getName().startsWith("javax.");
    }

    public static boolean isEnum(Type type) {
        if (type instanceof Class) {
            Class cls = (Class)type;
            return cls.isEnum();
        }
        return false;
    }

    /**
     * 将以'.'分割的类名改为以'/'为分割的类名
     *
     * @param sourceName
     * @return
     */
    public static String toInternalName(String sourceName) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int index = sourceName.indexOf('.', start);
        while (index != -1) {
            sb.append(sourceName.substring(start, index)).append('/');
            start = index + 1;
            index = sourceName.indexOf('.', start);
        }
        sb.append(sourceName.substring(start));
        return sb.toString();
    }

    public static String toLangName(String internalName) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int index = internalName.indexOf('/', start);
        while (index != -1) {
            sb.append(internalName.substring(start, index)).append('.');
            start = index + 1;
            index = internalName.indexOf('/', start);
        }
        sb.append(internalName.substring(start));
        return sb.toString();
    }

    public static int getAloadNum(String type) {
        switch (type) {
            case "I":  //int
                return Opcodes.IALOAD;
            case "J":
                return Opcodes.LALOAD;
            case "F":
                return Opcodes.FALOAD;
            case "D":
                return Opcodes.DALOAD;
            case "Z":
                return Opcodes.BALOAD;
            case "C":
                return Opcodes.CALOAD;
            case "S":
                return Opcodes.SALOAD;
            default:
                return Opcodes.AALOAD;
        }
    }

    public static int getLoadNum(String type) {
        switch (type) {
            case "I":  //int
                return Opcodes.ILOAD;
            case "J":
                return Opcodes.LLOAD;
            case "F":
                return Opcodes.FLOAD;
            case "D":
                return Opcodes.DLOAD;
            case "Z":
                return Opcodes.ILOAD;
            case "C":
                return Opcodes.ILOAD;
            case "S":
                return Opcodes.ILOAD;
            default:
                return Opcodes.ALOAD;
        }
    }

    public static int getAstoreNum(String type) {
        switch (type) {
            case "I":  //int
                return Opcodes.IASTORE;
            case "J":
                return Opcodes.LASTORE;
            case "F":
                return Opcodes.FASTORE;
            case "D":
                return Opcodes.DASTORE;
            case "Z":
                return Opcodes.BASTORE;
            case "C":
                return Opcodes.CASTORE;
            case "S":
                return Opcodes.SASTORE;
            default:
                return Opcodes.AASTORE;
        }
    }

    public static Type buildType(Class rawType, Type[] actualTypes) {
        return ParameterizedTypeImpl.make(rawType, actualTypes, null);
    }

    public static int getStoreNum(String type) {
        switch (type) {
            case "I":  //int
                return Opcodes.ISTORE;
            case "J":
                return Opcodes.LSTORE;
            case "F":
                return Opcodes.FSTORE;
            case "D":
                return Opcodes.DSTORE;
            case "Z":
                return Opcodes.ISTORE;
            case "C":
                return Opcodes.ISTORE;
            case "S":
                return Opcodes.ISTORE;
            default:
                return Opcodes.ASTORE;
        }
    }

    public static boolean isSet(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType ptype = (ParameterizedType)type;
            Class tclass = (Class)ptype.getRawType();
            return isSet(tclass);
        }
        return false;
    }

    public static boolean isSet(Class cls) {
        if (cls.getName().equals("java.util.Set")) {
            return true;
        }
        Class[] ifaces = cls.getInterfaces();
        for (Class c : ifaces) {
            if (isSetInterface(c)) {
                return true;
            }
        }
        Class pCls = cls.getSuperclass();
        while (pCls != null) {
            //System.out.println("pCls=" + pCls.getName());
            if (pCls.getName().equals("java.util.Set")) {
                return true;
            }
            pCls = pCls.getSuperclass();
        }
        return false;
    }

    public static boolean isSetInterface(Class cls) {
        if (cls.getName().equals("java.util.Set")) {
            return true;
        }
        Class[] ifaces = cls.getInterfaces();
        for (Class c : ifaces) {
            if (c.getName().equals("java.util.Set")) {
                return true;
            }
        }
        Class pCls = cls.getSuperclass();
        while (pCls != null) {
            if (pCls.getName().equals("java.util.Set")) {
                return true;
            }
            pCls = pCls.getSuperclass();
        }
        return false;
    }

    public static boolean isList(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType ptype = (ParameterizedType)type;
            Class tclass = (Class)ptype.getRawType();

            boolean isL = isList(tclass);
//            Type[] ts = ptype.getActualTypeArguments();
//            switch (ts[0].getTypeName()) {
//                case "java.lang.Long":
//                case "java.lang.Integer":
//                    return false;
//            }
            return isL;
        }
        return false;
    }

    public static boolean isListField(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType ptype = (ParameterizedType)type;
            Class tclass = (Class)ptype.getRawType();
            return isList(tclass);
        }
        return false;
    }

    public static boolean isList(Class cls) {
        if (cls.getName().equals("java.util.List")) {
            return true;
        }
        Class[] ifaces = cls.getInterfaces();
        for (Class c : ifaces) {
            if (isListInterface(c)) {
                return true;
            }
        }
        Class pCls = cls.getSuperclass();
        while (pCls != null) {
            //System.out.println("pCls=" + pCls.getName());
            if (pCls.getName().equals("java.util.List")) {
                return true;
            }
            pCls = pCls.getSuperclass();
        }
        return false;
    }

    public static boolean isListInterface(Class cls) {
        if (cls.getName().equals("java.util.List")) {
            return true;
        }
        Class[] ifaces = cls.getInterfaces();
        for (Class c : ifaces) {
            if (c.getName().equals("java.util.List")) {
                return true;
            }
        }
        Class pCls = cls.getSuperclass();
        while (pCls != null) {
            if (pCls.getName().equals("java.util.List")) {
                return true;
            }
            pCls = pCls.getSuperclass();
        }
        return false;
    }

    public static boolean isMap(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType ptype = (ParameterizedType)type;
            Class tclass = (Class)ptype.getRawType();
            return isMap(tclass);
        }
        return false;
    }

    public static boolean isMap(Class cls) {
        if ("java.util.Map".equals(cls.getName())) {
            return true;
        }
        Class[] ifaces = cls.getInterfaces();
        for (Class c : ifaces) {
            if (isMapInterface(c)) {
                return true;
            }
        }
        Class pCls = cls.getSuperclass();
        while (pCls != null) {
            if ("java.util.Map".equals(cls.getName())) {
                return true;
            }
            pCls = pCls.getSuperclass();
        }
        return false;
    }

    public static boolean isMapInterface(Class cls) {
        if (cls.getName().equals("java.util.Map")) {
            return true;
        }
        Class[] ifaces = cls.getInterfaces();
        for (Class c : ifaces) {
            if (c.getName().equals("java.util.Map")) {
                return true;
            }
        }
        Class pCls = cls.getSuperclass();
        while (pCls != null) {
            if (pCls.getName().equals("java.util.Map")) {
                return true;
            }
            pCls = pCls.getSuperclass();
        }
        return false;
    }
}
