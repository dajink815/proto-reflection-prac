// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/resources/protoc/RmqMessage.proto

package com.uangel.rmq.message;

public interface RmqHeaderOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.uangel.RmqHeader)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string type = 1;</code>
   * @return The type.
   */
  java.lang.String getType();
  /**
   * <code>string type = 1;</code>
   * @return The bytes for type.
   */
  com.google.protobuf.ByteString
      getTypeBytes();

  /**
   * <code>string transactionId = 2;</code>
   * @return The transactionId.
   */
  java.lang.String getTransactionId();
  /**
   * <code>string transactionId = 2;</code>
   * @return The bytes for transactionId.
   */
  com.google.protobuf.ByteString
      getTransactionIdBytes();

  /**
   * <code>string msgFrom = 3;</code>
   * @return The msgFrom.
   */
  java.lang.String getMsgFrom();
  /**
   * <code>string msgFrom = 3;</code>
   * @return The bytes for msgFrom.
   */
  com.google.protobuf.ByteString
      getMsgFromBytes();

  /**
   * <code>string timestamp = 4;</code>
   * @return The timestamp.
   */
  java.lang.String getTimestamp();
  /**
   * <code>string timestamp = 4;</code>
   * @return The bytes for timestamp.
   */
  com.google.protobuf.ByteString
      getTimestampBytes();

  /**
   * <code>int32 reasonCode = 5;</code>
   * @return The reasonCode.
   */
  int getReasonCode();

  /**
   * <code>string reason = 6;</code>
   * @return The reason.
   */
  java.lang.String getReason();
  /**
   * <code>string reason = 6;</code>
   * @return The bytes for reason.
   */
  com.google.protobuf.ByteString
      getReasonBytes();
}
