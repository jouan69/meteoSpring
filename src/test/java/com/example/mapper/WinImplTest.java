package com.example.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class WinImplTest {
    @Test
    public void shouldReturn1() throws Exception {
        WinImpl win = new WinImpl();
        Assert.assertTrue(win.getBeaufort(5.5) == 1);
    }

    @Test
    public void shouldReturn2() throws Exception {
        WinImpl win = new WinImpl();
        Assert.assertTrue(win.getBeaufort(6.1) == 2);
    }

    @Test
    public void shouldFindHeading(){
        WinImpl win = new WinImpl();
        Assert.assertTrue(win.getHeading(192.0).equals("S"));
    }
}