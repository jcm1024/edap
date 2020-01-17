// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: one_uint32.proto

package io.edap.protobuf.test.message.v3;

public final class OneUint32OuterClass {
  private OneUint32OuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface OneUint32OrBuilder extends
      // @@protoc_insertion_point(interface_extends:test.message.OneUint32)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>uint32 value = 1;</code>
     * @return The value.
     */
    int getValue();
  }
  /**
   * Protobuf type {@code test.message.OneUint32}
   */
  public  static final class OneUint32 extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:test.message.OneUint32)
      OneUint32OrBuilder {
  private static final long serialVersionUID = 0L;
    // Use OneUint32.newBuilder() to construct.
    private OneUint32(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private OneUint32() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new OneUint32();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private OneUint32(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {

              value_ = input.readUInt32();
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.edap.protobuf.test.message.v3.OneUint32OuterClass.internal_static_test_message_OneUint32_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.edap.protobuf.test.message.v3.OneUint32OuterClass.internal_static_test_message_OneUint32_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32.class, io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32.Builder.class);
    }

    public static final int VALUE_FIELD_NUMBER = 1;
    private int value_;
    /**
     * <code>uint32 value = 1;</code>
     * @return The value.
     */
    public int getValue() {
      return value_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (value_ != 0) {
        output.writeUInt32(1, value_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (value_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(1, value_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32)) {
        return super.equals(obj);
      }
      io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 other = (io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32) obj;

      if (getValue()
          != other.getValue()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getValue();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code test.message.OneUint32}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:test.message.OneUint32)
        io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32OrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return io.edap.protobuf.test.message.v3.OneUint32OuterClass.internal_static_test_message_OneUint32_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return io.edap.protobuf.test.message.v3.OneUint32OuterClass.internal_static_test_message_OneUint32_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32.class, io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32.Builder.class);
      }

      // Construct using io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        value_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return io.edap.protobuf.test.message.v3.OneUint32OuterClass.internal_static_test_message_OneUint32_descriptor;
      }

      @java.lang.Override
      public io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 getDefaultInstanceForType() {
        return io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32.getDefaultInstance();
      }

      @java.lang.Override
      public io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 build() {
        io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 buildPartial() {
        io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 result = new io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32(this);
        result.value_ = value_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32) {
          return mergeFrom((io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 other) {
        if (other == io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32.getDefaultInstance()) return this;
        if (other.getValue() != 0) {
          setValue(other.getValue());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int value_ ;
      /**
       * <code>uint32 value = 1;</code>
       * @return The value.
       */
      public int getValue() {
        return value_;
      }
      /**
       * <code>uint32 value = 1;</code>
       * @param value The value to set.
       * @return This builder for chaining.
       */
      public Builder setValue(int value) {
        
        value_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 value = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearValue() {
        
        value_ = 0;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:test.message.OneUint32)
    }

    // @@protoc_insertion_point(class_scope:test.message.OneUint32)
    private static final io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32();
    }

    public static io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<OneUint32>
        PARSER = new com.google.protobuf.AbstractParser<OneUint32>() {
      @java.lang.Override
      public OneUint32 parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new OneUint32(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<OneUint32> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<OneUint32> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public io.edap.protobuf.test.message.v3.OneUint32OuterClass.OneUint32 getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_test_message_OneUint32_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_test_message_OneUint32_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020one_uint32.proto\022\014test.message\"\032\n\tOneU" +
      "int32\022\r\n\005value\030\001 \001(\rB\"\n io.edap.protobuf" +
      ".test.message.v3b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_test_message_OneUint32_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_test_message_OneUint32_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_test_message_OneUint32_descriptor,
        new java.lang.String[] { "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}