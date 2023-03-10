// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/resources/protoc/RmqMessage.proto

package com.uangel.rmq.message;

/**
 * Protobuf type {@code com.uangel.HeartbeatReq}
 */
public final class HeartbeatReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.uangel.HeartbeatReq)
    HeartbeatReqOrBuilder {
private static final long serialVersionUID = 0L;
  // Use HeartbeatReq.newBuilder() to construct.
  private HeartbeatReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private HeartbeatReq() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new HeartbeatReq();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private HeartbeatReq(
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

            cpuUsage_ = input.readInt32();
            break;
          }
          case 16: {

            memoryUsage_ = input.readInt32();
            break;
          }
          case 24: {

            sessionCount_ = input.readInt32();
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
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
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
    return com.uangel.rmq.message.RmqMsg.internal_static_com_uangel_HeartbeatReq_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.uangel.rmq.message.RmqMsg.internal_static_com_uangel_HeartbeatReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.uangel.rmq.message.HeartbeatReq.class, com.uangel.rmq.message.HeartbeatReq.Builder.class);
  }

  public static final int CPU_USAGE_FIELD_NUMBER = 1;
  private int cpuUsage_;
  /**
   * <code>int32 cpu_usage = 1;</code>
   * @return The cpuUsage.
   */
  @java.lang.Override
  public int getCpuUsage() {
    return cpuUsage_;
  }

  public static final int MEMORY_USAGE_FIELD_NUMBER = 2;
  private int memoryUsage_;
  /**
   * <code>int32 memory_usage = 2;</code>
   * @return The memoryUsage.
   */
  @java.lang.Override
  public int getMemoryUsage() {
    return memoryUsage_;
  }

  public static final int SESSION_COUNT_FIELD_NUMBER = 3;
  private int sessionCount_;
  /**
   * <code>int32 session_count = 3;</code>
   * @return The sessionCount.
   */
  @java.lang.Override
  public int getSessionCount() {
    return sessionCount_;
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
    if (cpuUsage_ != 0) {
      output.writeInt32(1, cpuUsage_);
    }
    if (memoryUsage_ != 0) {
      output.writeInt32(2, memoryUsage_);
    }
    if (sessionCount_ != 0) {
      output.writeInt32(3, sessionCount_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (cpuUsage_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, cpuUsage_);
    }
    if (memoryUsage_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, memoryUsage_);
    }
    if (sessionCount_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, sessionCount_);
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
    if (!(obj instanceof com.uangel.rmq.message.HeartbeatReq)) {
      return super.equals(obj);
    }
    com.uangel.rmq.message.HeartbeatReq other = (com.uangel.rmq.message.HeartbeatReq) obj;

    if (getCpuUsage()
        != other.getCpuUsage()) return false;
    if (getMemoryUsage()
        != other.getMemoryUsage()) return false;
    if (getSessionCount()
        != other.getSessionCount()) return false;
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
    hash = (37 * hash) + CPU_USAGE_FIELD_NUMBER;
    hash = (53 * hash) + getCpuUsage();
    hash = (37 * hash) + MEMORY_USAGE_FIELD_NUMBER;
    hash = (53 * hash) + getMemoryUsage();
    hash = (37 * hash) + SESSION_COUNT_FIELD_NUMBER;
    hash = (53 * hash) + getSessionCount();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.uangel.rmq.message.HeartbeatReq parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.uangel.rmq.message.HeartbeatReq parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.uangel.rmq.message.HeartbeatReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.uangel.rmq.message.HeartbeatReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.uangel.rmq.message.HeartbeatReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.uangel.rmq.message.HeartbeatReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.uangel.rmq.message.HeartbeatReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.uangel.rmq.message.HeartbeatReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.uangel.rmq.message.HeartbeatReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.uangel.rmq.message.HeartbeatReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.uangel.rmq.message.HeartbeatReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.uangel.rmq.message.HeartbeatReq parseFrom(
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
  public static Builder newBuilder(com.uangel.rmq.message.HeartbeatReq prototype) {
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
   * Protobuf type {@code com.uangel.HeartbeatReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.uangel.HeartbeatReq)
      com.uangel.rmq.message.HeartbeatReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.uangel.rmq.message.RmqMsg.internal_static_com_uangel_HeartbeatReq_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.uangel.rmq.message.RmqMsg.internal_static_com_uangel_HeartbeatReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.uangel.rmq.message.HeartbeatReq.class, com.uangel.rmq.message.HeartbeatReq.Builder.class);
    }

    // Construct using com.uangel.rmq.message.HeartbeatReq.newBuilder()
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
      cpuUsage_ = 0;

      memoryUsage_ = 0;

      sessionCount_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.uangel.rmq.message.RmqMsg.internal_static_com_uangel_HeartbeatReq_descriptor;
    }

    @java.lang.Override
    public com.uangel.rmq.message.HeartbeatReq getDefaultInstanceForType() {
      return com.uangel.rmq.message.HeartbeatReq.getDefaultInstance();
    }

    @java.lang.Override
    public com.uangel.rmq.message.HeartbeatReq build() {
      com.uangel.rmq.message.HeartbeatReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.uangel.rmq.message.HeartbeatReq buildPartial() {
      com.uangel.rmq.message.HeartbeatReq result = new com.uangel.rmq.message.HeartbeatReq(this);
      result.cpuUsage_ = cpuUsage_;
      result.memoryUsage_ = memoryUsage_;
      result.sessionCount_ = sessionCount_;
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
      if (other instanceof com.uangel.rmq.message.HeartbeatReq) {
        return mergeFrom((com.uangel.rmq.message.HeartbeatReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.uangel.rmq.message.HeartbeatReq other) {
      if (other == com.uangel.rmq.message.HeartbeatReq.getDefaultInstance()) return this;
      if (other.getCpuUsage() != 0) {
        setCpuUsage(other.getCpuUsage());
      }
      if (other.getMemoryUsage() != 0) {
        setMemoryUsage(other.getMemoryUsage());
      }
      if (other.getSessionCount() != 0) {
        setSessionCount(other.getSessionCount());
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
      com.uangel.rmq.message.HeartbeatReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.uangel.rmq.message.HeartbeatReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int cpuUsage_ ;
    /**
     * <code>int32 cpu_usage = 1;</code>
     * @return The cpuUsage.
     */
    @java.lang.Override
    public int getCpuUsage() {
      return cpuUsage_;
    }
    /**
     * <code>int32 cpu_usage = 1;</code>
     * @param value The cpuUsage to set.
     * @return This builder for chaining.
     */
    public Builder setCpuUsage(int value) {
      
      cpuUsage_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 cpu_usage = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCpuUsage() {
      
      cpuUsage_ = 0;
      onChanged();
      return this;
    }

    private int memoryUsage_ ;
    /**
     * <code>int32 memory_usage = 2;</code>
     * @return The memoryUsage.
     */
    @java.lang.Override
    public int getMemoryUsage() {
      return memoryUsage_;
    }
    /**
     * <code>int32 memory_usage = 2;</code>
     * @param value The memoryUsage to set.
     * @return This builder for chaining.
     */
    public Builder setMemoryUsage(int value) {
      
      memoryUsage_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 memory_usage = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMemoryUsage() {
      
      memoryUsage_ = 0;
      onChanged();
      return this;
    }

    private int sessionCount_ ;
    /**
     * <code>int32 session_count = 3;</code>
     * @return The sessionCount.
     */
    @java.lang.Override
    public int getSessionCount() {
      return sessionCount_;
    }
    /**
     * <code>int32 session_count = 3;</code>
     * @param value The sessionCount to set.
     * @return This builder for chaining.
     */
    public Builder setSessionCount(int value) {
      
      sessionCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 session_count = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearSessionCount() {
      
      sessionCount_ = 0;
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


    // @@protoc_insertion_point(builder_scope:com.uangel.HeartbeatReq)
  }

  // @@protoc_insertion_point(class_scope:com.uangel.HeartbeatReq)
  private static final com.uangel.rmq.message.HeartbeatReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.uangel.rmq.message.HeartbeatReq();
  }

  public static com.uangel.rmq.message.HeartbeatReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<HeartbeatReq>
      PARSER = new com.google.protobuf.AbstractParser<HeartbeatReq>() {
    @java.lang.Override
    public HeartbeatReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new HeartbeatReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<HeartbeatReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<HeartbeatReq> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.uangel.rmq.message.HeartbeatReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

