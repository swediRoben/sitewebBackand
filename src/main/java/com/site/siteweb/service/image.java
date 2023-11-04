package com.site.siteweb.service;
    import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO; 
public class image {

    public static void gfdgf() {
        try {
            // Charger l'image
            BufferedImage image = ImageIO.read(new File("path/to/image.jpg"));

            // Réduire la taille de l'image
            int width = image.getWidth() / 4;
            int height = image.getHeight() / 4;
            BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int color = image.getRGB(x * 4, y * 4);
                    resizedImage.setRGB(x, y, color);
                }
            }

            // Enregistrer l'image réduite
            ImageIO.write(resizedImage, "jpg", new File("path/to/resized-image.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 
