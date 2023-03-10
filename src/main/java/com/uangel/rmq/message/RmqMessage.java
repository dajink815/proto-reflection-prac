// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/resources/protoc/RmqMessage.proto

package com.uangel.rmq.message;

/**
 * Protobuf type {@code com.uangel.RmqMessage}
 */
public final class RmqMessage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.uangel.RmqMessage)
    RmqMessageOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RmqMessage.newBuilder() to construct.
  private RmqMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RmqMessage() {
    body_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RmqMessage();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RmqMessage(
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
          case 10: {
            com.uangel.rmq.message.RmqHeader.Builder subBuilder = null;
            if (header_ != null) {
              subBuilder = header_.toBuilder();
            }
            header_ = input.readMessage(com.uangel.rmq.message.RmqHeader.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(header_);
              header_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {

            body_ = input.readBytes();
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
    return com.uangel.rmq.message.RmqMsg.internal_static_com_uangel_RmqMessage_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.uangel.rmq.message.RmqMsg.internal_static_com_uangel_RmqMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.uangel.rmq.message.RmqMessage.class, com.uangel.rmq.message.RmqMessage.Builder.class);
  }

  public static final int HEADER_FIELD_NUMBER = 1;
  private com.uangel.rmq.message.RmqHeader header_;
  /**
   * <code>.com.uangel.RmqHeader header = 1;</code>
   * @return Whether the header field is set.
   */
  @java.lang.Override
  public boolean hasHeader() {
    return header_ != null;
  }
  /**
   * <code>.com.uangel.RmqHeader header = 1;</code>
   * @return The header.
   */
  @java.lang.Override
  public com.uangel.rmq.message.RmqHeader getHeader() {
    return header_ == null ? com.uangel.rmq.message.RmqHeader.getDefaultInstance() : header_;
  }
  /**
   * <code>.com.uangel.RmqHeader header = 1;</code>
   */
  @java.lang.Override
  public com.uangel.rmq.message.RmqHeaderOrBuilder getHeaderOrBuilder() {
    return getHeader();
  }

  public static final int BODY_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString body_;
  /**
   * <code>bytes body = 2;</code>
   * @return The body.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getBody() {
    return body_;
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
    if (header_ != null) {
      output.writeMessage(1, getHeader());
    }
    if (!body_.isEmpty()) {
      output.writeBytes(2, body_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (header_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getHeader());
    }
    if (!body_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, body_);
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
    if (!(obj instanceof com.uangel.rmq.message.RmqMessage)) {
      return super.equals(obj);
    }
    com.uangel.rmq.message.RmqMessage other = (com.uangel.rmq.message.RmqMessage) obj;

    if (hasHeader() != other.hasHeader()) return false;
    if (hasHeader()) {
      if (!getHeader()
          .equals(other.getHeader())) return false;
    }
    if (!getBody()
        .equals(other.getBody())) return false;
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
    if (hasHeader()) {
      hash = (37 * hash) + HEADER_FIELD_NUMBER;
      hash = (53 * hash) + getHeader().hashCode();
    }
    hash = (37 * hash) + BODY_FIELD_NUMBER;
    hash = (53 * hash) + getBody().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.uangel.rmq.message.RmqMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.uangel.rmq.message.RmqMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.uangel.rmq.message.RmqMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.uangel.rmq.message.RmqMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.uangel.rmq.message.RmqMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.uangel.rmq.message.RmqMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.uangel.rmq.message.RmqMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.uangel.rmq.message.RmqMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.uangel.rmq.message.RmqMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.uangel.rmq.message.RmqMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.uangel.rmq.message.RmqMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.uangel.rmq.message.RmqMessage parseFrom(
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
  public static Builder newBuilder(com.uangel.rmq.message.RmqMessage prototype) {
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
   * Protobuf type {@code com.uangel.RmqMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.uangel.RmqMessage)
      com.uangel.rmq.message.RmqMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.uangel.rmq.message.RmqMsg.internal_static_com_uangel_RmqMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.uangel.rmq.message.RmqMsg.internal_static_com_uangel_RmqMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.uangel.rmq.message.RmqMessage.class, com.uangel.rmq.message.RmqMessage.Builder.class);
    }

    // Construct using com.uangel.rmq.message.RmqMessage.newBuilder()
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
      if (headerBuilder_ == null) {
        header_ = null;
      } else {
        header_ = null;
        headerBuilder_ = null;
      }
      body_ = com.google.protobuf.ByteString.EMPTY;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.uangel.rmq.message.RmqMsg.internal_static_com_uangel_RmqMessage_descriptor;
    }

    @java.lang.Override
    public com.uangel.rmq.message.RmqMessage getDefaultInstanceForType() {
      return com.uangel.rmq.message.RmqMessage.getDefaultInstance();
    }

    @java.lang.Override
    public com.uangel.rmq.message.RmqMessage build() {
      com.uangel.rmq.message.RmqMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.uangel.rmq.message.RmqMessage buildPartial() {
      com.uangel.rmq.message.RmqMessage result = new com.uangel.rmq.message.RmqMessage(this);
      if (headerBuilder_ == null) {
        result.header_ = header_;
      } else {
        result.header_ = headerBuilder_.build();
      }
      result.body_ = body_;
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
      if (other instanceof com.uangel.rmq.message.RmqMessage) {
        return mergeFrom((com.uangel.rmq.message.RmqMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.uangel.rmq.message.RmqMessage other) {
      if (other == com.uangel.rmq.message.RmqMessage.getDefaultInstance()) return this;
      if (other.hasHeader()) {
        mergeHeader(other.getHeader());
      }
      if (other.getBody() != com.google.protobuf.ByteString.EMPTY) {
        setBody(other.getBody());
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
      com.uangel.rmq.message.RmqMessage parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.uangel.rmq.message.RmqMessage) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.uangel.rmq.message.RmqHeader header_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.uangel.rmq.message.RmqHeader, com.uangel.rmq.message.RmqHeader.Builder, com.uangel.rmq.message.RmqHeaderOrBuilder> headerBuilder_;
    /**
     * <code>.com.uangel.RmqHeader header = 1;</code>
     * @return Whether the header field is set.
     */
    public boolean hasHeader() {
      return headerBuilder_ != null || header_ != null;
    }
    /**
     * <code>.com.uangel.RmqHeader header = 1;</code>
     * @return The header.
     */
    public com.uangel.rmq.message.RmqHeader getHeader() {
      if (headerBuilder_ == null) {
        return header_ == null ? com.uangel.rmq.message.RmqHeader.getDefaultInstance() : header_;
      } else {
        return headerBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.uangel.RmqHeader header = 1;</code>
     */
    public Builder setHeader(com.uangel.rmq.message.RmqHeader value) {
      if (headerBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        header_ = value;
        onChanged();
      } else {
        headerBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.uangel.RmqHeader header = 1;</code>
     */
    public Builder setHeader(
        com.uangel.rmq.message.RmqHeader.Builder builderForValue) {
      if (headerBuilder_ == null) {
        header_ = builderForValue.build();
        onChanged();
      } else {
        headerBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.uangel.RmqHeader header = 1;</code>
     */
    public Builder mergeHeader(com.uangel.rmq.message.RmqHeader value) {
      if (headerBuilder_ == null) {
        if (header_ != null) {
          header_ =
            com.uangel.rmq.message.RmqHeader.newBuilder(header_).mergeFrom(value).buildPartial();
        } else {
          header_ = value;
        }
        onChanged();
      } else {
        headerBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.uangel.RmqHeader header = 1;</code>
     */
    public Builder clearHeader() {
      if (headerBuilder_ == null) {
        header_ = null;
        onChanged();
      } else {
        header_ = null;
        headerBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.uangel.RmqHeader header = 1;</code>
     */
    public com.uangel.rmq.message.RmqHeader.Builder getHeaderBuilder() {
      
      onChanged();
      return getHeaderFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.uangel.RmqHeader header = 1;</code>
     */
    public com.uangel.rmq.message.RmqHeaderOrBuilder getHeaderOrBuilder() {
      if (headerBuilder_ != null) {
        return headerBuilder_.getMessageOrBuilder();
      } else {
        return header_ == null ?
            com.uangel.rmq.message.RmqHeader.getDefaultInstance() : header_;
      }
    }
    /**
     * <code>.com.uangel.RmqHeader header = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.uangel.rmq.message.RmqHeader, com.uangel.rmq.message.RmqHeader.Builder, com.uangel.rmq.message.RmqHeaderOrBuilder> 
        getHeaderFieldBuilder() {
      if (headerBuilder_ == null) {
        headerBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.uangel.rmq.message.RmqHeader, com.uangel.rmq.message.RmqHeader.Builder, com.uangel.rmq.message.RmqHeaderOrBuilder>(
                getHeader(),
                getParentForChildren(),
                isClean());
        header_ = null;
      }
      return headerBuilder_;
    }

    private com.google.protobuf.ByteString body_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes body = 2;</code>
     * @return The body.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getBody() {
      return body_;
    }
    /**
     * <code>bytes body = 2;</code>
     * @param value The body to set.
     * @return This builder for chaining.
     */
    public Builder setBody(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      body_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes body = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearBody() {
      
      body_ = getDefaultInstance().getBody();
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


    // @@protoc_insertion_point(builder_scope:com.uangel.RmqMessage)
  }

  // @@protoc_insertion_point(class_scope:com.uangel.RmqMessage)
  private static final com.uangel.rmq.message.RmqMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.uangel.rmq.message.RmqMessage();
  }

  public static com.uangel.rmq.message.RmqMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RmqMessage>
      PARSER = new com.google.protobuf.AbstractParser<RmqMessage>() {
    @java.lang.Override
    public RmqMessage parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RmqMessage(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RmqMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RmqMessage> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.uangel.rmq.message.RmqMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

