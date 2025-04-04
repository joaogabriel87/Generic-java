package Exercicios.Cor;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class seletorCor {
   private static final Map<String, Color> colorMap = new HashMap<String, Color>();

   static {
       colorMap.put("BLACK", Color.BLACK);
       colorMap.put("BLUE", Color.BLUE);
       colorMap.put("CYAN", Color.CYAN);
       colorMap.put("DARK_GRAY", Color.DARK_GRAY);
       colorMap.put("GRAY", Color.GRAY);
       colorMap.put("GREEN", Color.GREEN);
       colorMap.put("LIGHT_GRAY", Color.LIGHT_GRAY);
       colorMap.put("MAGENTA", Color.MAGENTA);
       colorMap.put("ORANGE", Color.ORANGE);
       colorMap.put("PINK", Color.PINK);
       colorMap.put("RED", Color.RED);
       colorMap.put("WHITE", Color.WHITE);
       colorMap.put("YELLOW", Color.YELLOW);

   }

   public static Color getColor(String color) {
       return colorMap.getOrDefault(color.toUpperCase(), Color.BLACK);
   }

   public static Set<String> getColors() {
       return colorMap.keySet();
   }
}
