package by.epamtc.poliukov.task02.service;

import by.epamtc.poliukov.task02.entity.Color;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnalysisColorTest {
    AnalysisColor analysisColor = new AnalysisColor();
    @Test
    public void analyzeColor() {
        Color expected = Color.BLUE;
        Color actual = analysisColor.analyzeColor("b");
        assertEquals(expected, actual);
    }
}