/*   Copyright (c) 2015 Magnet Systems, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.magnet.mmx.server.plugin.mmxmgmt.web;

/**
 * Enum for encapsulating the search options for a message entity
 * @author login3
 *
 */
public enum MessageSearchOption {

  MESSAGE_ID ("messageid", new MessageSingleValueValidator() ),
  DATE_SENT ("datesent", new MessageTimeRangeSearchValidator()),
  DATE_ACKNOWLEDGED ("dateack", new MessageTimeRangeSearchValidator()),
  TARGET_DEVICE_ID("targetdevid",new MessageSingleValueValidator()),
  MESSAGE_STATE("state", new MessageSingleValueValidator())
  ;
  
  private String option;
  private MessageSearchValidator validator;
  
  private MessageSearchOption(String _option, MessageSearchValidator validator) {
    this.option = _option;
    this.validator = validator;
  }
  
  public static MessageSearchOption find (String option) {
    if (option == null) {
      return null;
    }
    MessageSearchOption rv = null;
    for (MessageSearchOption possible : MessageSearchOption.values()) {
      if (possible.option.equalsIgnoreCase(option)) {
        rv = possible;
        break;
      }
    }
    return rv;
  }

  public MessageSearchValidator getValidator() {
    return validator;
  }
}
