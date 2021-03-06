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

package io.edap.protobuf.ext.codec;

import io.edap.protobuf.EncodeException;
import io.edap.protobuf.ProtoBufException;
import io.edap.protobuf.ProtoBufReader;
import io.edap.protobuf.ProtoBufWriter;
import io.edap.protobuf.ext.ExtCodec;

import static io.edap.protobuf.ext.AnyCodec.RANGE_STRING_END;
import static io.edap.protobuf.ext.AnyCodec.RANGE_STRING_START;

/**
 * 字符串类的编解码器
 */
public class StringCodec implements ExtCodec<String> {

    private Integer len;

    public StringCodec() {

    }

    public StringCodec(Integer len) {
        this.len = len;
    }

    @Override
    public String decode(ProtoBufReader reader) throws ProtoBufException {
        if (null != len) {
            return reader.readString(len);
        }
        int l = reader.readInt32();
        return reader.readString(l);
    }

    @Override
    public void encode(ProtoBufWriter writer, String s) throws EncodeException {
        int len = s.length();
        if (len < RANGE_STRING_END - RANGE_STRING_START) {
            if (writer.getWriteOrder() == ProtoBufWriter.WriteOrder.SEQUENTIAL) {
                writer.writeInt32(RANGE_STRING_START + len);
                writer.writeStringUtf8(s, -1);
            } else {
                writer.writeStringUtf8(s, -1);
                writer.writeInt32(RANGE_STRING_START + len);
            }
            return;
        }
        if (writer.getWriteOrder() == ProtoBufWriter.WriteOrder.SEQUENTIAL) {
            writer.writeInt32(RANGE_STRING_END);
            writer.writeInt32(len);
            writer.writeStringUtf8(s, -1);
        } else {
            writer.writeStringUtf8(s, -1);
            writer.writeInt32(len);
            writer.writeInt32(RANGE_STRING_END);
        }
    }
}