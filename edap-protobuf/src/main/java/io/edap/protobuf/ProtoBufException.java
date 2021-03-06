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

package io.edap.protobuf;

import java.io.IOException;

public class ProtoBufException extends IOException {

    public ProtoBufException(final String description) {
        super(description);
    }

    public ProtoBufException(IOException e) {
        super(e.getMessage(), e);
    }

    public ProtoBufException(Exception e) {
        super(e.getMessage(), e);
    }

    public ProtoBufException(final String description, IOException e) {
        super(description, e);
    }

    /**
     * Unwraps the underlying {@link IOException} if this exception was caused
     * by an I/O problem. Otherwise, returns {@code this}.
     */
    public IOException unwrapIOException() {
        return getCause() instanceof IOException ? (IOException) getCause() : this;
    }

    public static ProtoBufException truncatedMessage() {
        return new ProtoBufException(
                "While parsing a protocol message, the input ended unexpectedly "
                        + "in the middle of a field.  This could mean either that the "
                        + "input has been truncated or that an embedded message "
                        + "misreported its own length.");
    }

    public static ProtoBufException negativeSize() {
        return new ProtoBufException(
                "CodedInputStream encountered an embedded string or message "
                        + "which claimed to have negative size.");
    }

    public static ProtoBufException malformedVarint() {
        return new ProtoBufException(
                "CodedInputStream encountered a malformed varint.");
    }

    public static ProtoBufException invalidTag() {
        return new ProtoBufException(
                "Protocol message contained an invalid tag (zero).");
    }

    public static ProtoBufException invalidEndTag() {
        return new ProtoBufException(
                "Protocol message end-group tag did not match expected tag.");
    }

    public static InvalidWireTypeException invalidWireType() {
        return new InvalidWireTypeException(
                "Protocol message tag had invalid wire type.");
    }

    /**
     * Exception indicating that and unexpected wire type was encountered for a
     * field.
     */
    public static class InvalidWireTypeException extends ProtoBufException {

        private static final long serialVersionUID = 3283890091615336259L;

        public InvalidWireTypeException(String description) {
            super(description);
        }
    }

    public static ProtoBufException recursionLimitExceeded() {
        return new ProtoBufException(
                "Protocol message had too many levels of nesting.  May be malicious.  "
                        + "Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public static ProtoBufException sizeLimitExceeded() {
        return new ProtoBufException(
                "Protocol message was too large.  May be malicious.  "
                        + "Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static ProtoBufException parseFailure() {
        return new ProtoBufException("Failed to parse the message.");
    }

    public static ProtoBufException invalidUtf8() {
        return new ProtoBufException("Protocol message had invalid UTF-8.");
    }
}