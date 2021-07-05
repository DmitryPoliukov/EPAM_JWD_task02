package by.epamtc.poliukov.task02.service;

import by.epamtc.poliukov.task02.entity.Color;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class AnalysisColor analyzes the color of the ball by letter from the console.
 *
 * @author Dmitry Poliukov
 */
public class AnalysisColor {
    private Map<String, Color> colorHashMap = new HashMap<>();
    {
        colorHashMap.put("r", Color.RED);
        colorHashMap.put("b", Color.BLUE);
        colorHashMap.put("w", Color.WHITE);
        colorHashMap.put("g", Color.GREEN);
    }

    public Color analyzeColor(String inputColor) {
        Color color = colorHashMap.get(inputColor);
        return color;
    }



}
