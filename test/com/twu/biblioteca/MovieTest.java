package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

public class MovieTest {

    @Test
    public void movieExtendsLibraryItem() {
        Assert.assertTrue(LibraryItem.class.isAssignableFrom(Movie.class));
    }
}
