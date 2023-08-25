/*
 * Created by Michael Carrara <michael.carrara@breadwallet.com> on 7/1/19.
 * Copyright (c) 2019 Breadwinner AG.  All right reserved.
*
 * See the LICENSE file at the project root for license information.
 * See the CONTRIBUTORS file at the project root for a list of contributors.
 */
package com.breadwallet.corenative.utility;

import com.google.common.primitives.UnsignedInts;
import com.google.common.primitives.UnsignedLong;
import com.sun.jna.Native;
import com.sun.jna.ptr.ByReference;

import org.checkerframework.checker.signedness.qual.Signed;
import org.checkerframework.checker.signedness.qual.Unsigned;

public class SizeTByReference extends ByReference {

    public SizeTByReference() {
        this(UnsignedLong.ZERO);
    }

    public SizeTByReference(UnsignedLong value) {
        super(Native.SIZE_T_SIZE);
        setValue(value);
    }

    //@SuppressWarnings("signedness:cast.unsafe")
    public void setValue(UnsignedLong value) {
        if (Native.SIZE_T_SIZE == 8) {
            getPointer().setLong(0, value.longValue());
        } else {
            getPointer().setInt(0, (@Signed int) UnsignedInts.checkedCast(value.longValue()));
        }
    }

    //@SuppressWarnings("signedness:cast.unsafe")
    public UnsignedLong getValue() {
        if (Native.SIZE_T_SIZE == 8) {
            return UnsignedLong.fromLongBits((@Unsigned long) getPointer().getLong(0));
        } else {
            return UnsignedLong.fromLongBits((@Unsigned long) getPointer().getInt(0));
        }
    }
}
