package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

public class BookTest {
    @Test
    public void bookExtendsLibraryItem() {
        Assert.assertTrue(LibraryItem.class.isAssignableFrom(Book.class));
    }
}
