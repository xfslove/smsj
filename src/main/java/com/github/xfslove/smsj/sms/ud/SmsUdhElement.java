/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is "SMS Library for the Java platform".
 *
 * The Initial Developer of the Original Code is Markus Eriksson.
 * Portions created by the Initial Developer are Copyright (C) 2002
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */
package com.github.xfslove.smsj.sms.ud;

import java.io.Serializable;

/**
 * Represents an User Data Header Element
 *
 * @author Markus Eriksson
 * @version $Id$
 */
public final class SmsUdhElement implements Serializable {

  private final SmsUdhIei udhIei;

  private final byte[] udhIeiData;

  /**
   * Creates an SmsUdhElement
   *
   * @param udhIei     udhi
   * @param udhIeiData data
   */
  public SmsUdhElement(SmsUdhIei udhIei, byte[] udhIeiData) {
    this.udhIei = udhIei;
    this.udhIeiData = udhIeiData;
  }

  /**
   * Returns the total length of this UDH element.
   * <p>
   * The length is including the UDH data length and the UDH "header" (2 bytes)
   *
   * @return the length
   */
  public int getTotalSize() {
    return udhIeiData.length + 2;
  }

  /**
   * Returns the length of the UDH iei data
   * <p>
   * The length returned is only the length of the data
   *
   * @return Length of data
   */
  public int getUdhIeiDataLength() {
    return udhIeiData.length;
  }

  /**
   * Returns the Udh Iei Data excluding the UDH "header"
   *
   * @return Data
   */
  public byte[] getUdhIeiData() {
    return udhIeiData;
  }

  /**
   * Returns the Udh Iei
   *
   * @return Udh Iei
   */
  public SmsUdhIei getUdhIei() {
    return udhIei;
  }

  /**
   * Return the UDH element including the UDH "header" (two bytes)
   *
   * @return Data
   */
  public byte[] getData() {
    byte[] allData = new byte[udhIeiData.length + 2];

    allData[0] = (byte) (udhIei.getValue() & 0xff);
    allData[1] = (byte) (udhIeiData.length & 0xff);
    System.arraycopy(udhIeiData, 0, allData, 2, udhIeiData.length);

    return allData;
  }
}
