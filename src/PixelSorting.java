import processing.core.PApplet;
import processing.core.PImage;

public class PixelSorting extends PApplet {

    PImage img;
    PImage sorted;
    int index = 0;

    public static void main(String[] args) {
        String[] processingArgs = {"PixelSorting"};
        PixelSorting pixelSorting = new PixelSorting();
        PApplet.runSketch(processingArgs, pixelSorting);

    }

    public void settings() {
        img = loadImage("images/image1.jpg");
        img.resize(img.width / 2, img.height / 2);
        size(img.width, img.height);
        sorted = createImage(img.width, img.height, RGB);
        sorted = img.get();

    }

    public void setup() {
        frameRate(60);
    }

    public void draw() {
        println(frameRate);
        for (int i = 0; i < 5; i++) {
            image(sorted, 0, 0);
            int selected = index;
            float biggest = -1;
            for (int j = index; j < sorted.pixels.length; j++) {
                if (hue(sorted.pixels[j]) > biggest) {
                    selected = j;
                    biggest = hue(sorted.pixels[j]);
                }
            }

            int tmp = sorted.pixels[selected];
            sorted.pixels[selected] = sorted.pixels[index];
            sorted.pixels[index] = tmp;
            sorted.updatePixels();

            if (index < sorted.pixels.length) {
                index++;
            }
        }

    }
}