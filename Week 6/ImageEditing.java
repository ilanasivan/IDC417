public class ImageEditing {

    /**
     * Renders an image using StdDraw.
     * The input array is assumed to contain integers in the range [0,255].
     * With the third dimension being of size 3.
     *
     * @param pic - the image to show.
     */

    public static void show(int[][][] pic) {
        StdDraw.setCanvasSize(pic[0].length, pic.length);
        int height = pic.length;
        int width = pic[0].length;
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.show(30);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                StdDraw.setPenColor(pic[i][j][0], pic[i][j][1], pic[i][j][2]);
                StdDraw.filledRectangle(j + 0.5, height - i - 0.5, 0.5, 0.5);
            }
        }
        StdDraw.show();
    }

    /**
     * Reads an image using StdIn
     *
     * @param filename - String name of image being read
     * @return rgbArray, the RGB values saved to an int[][][]
     */

    public static int[][][] read(String filename) {
        StdIn.setInput(filename);
        while (StdIn.readChar() != '\n') ;
        int columns = StdIn.readInt();
        int rows = StdIn.readInt();
        int maxIntensity = StdIn.readInt();
        int[][][] rgbArray = new int[rows][columns][3];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                rgbArray[i][j][0] = StdIn.readInt();
                rgbArray[i][j][1] = StdIn.readInt();
                rgbArray[i][j][2] = StdIn.readInt();
            }
        }
        return rgbArray;
    }

    /**
     * Prints out the RGB value of the ppm file
     *
     * @param source - file read into int[][][]
     * @return printed values of the RGB for each pixel in the array
     */

    public static void print(int[][][] source) {

        // Iterate through arrays and print values of RGB in pixels
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                StdOut.print("   ");
                for (int k = 0; k < 3; k++) {
                    StdOut.printf("%4d", source[i][j][k]);
                }
            }
            System.out.println();
        }
    }

    /**
     * Flips image horizontally
     *
     * @param source - file read as int[][][]
     * @return flippedHorArray, an int[][][] with the column locations reversed from source
     */

    public static int[][][] flipHorizontal(int[][][] source) {

        // Initialize a storage array
        int[][][] flippedHorArray = new int[source.length][source[0].length][3];

        // Iterate through array and reverse locations horizontally
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                flippedHorArray[i][source[0].length - 1 - j] = source[i][j];
            }
        }

        // Return manipulated array
        return flippedHorArray;
    }

    /**
     * Flips image vertically
     *
     * @param source - file read as int[][][]
     * @return flippedVertArray, an int[][][] with the row locations reversed from source
     */

    public static int[][][] flipVertical(int[][][] source) {

        // Intialize a storage array
        int[][][] flippedVertArray = new int[source.length][source[0].length][3];

        // Iterate through the
        for (int i = 0; i < source.length; i++) {
            flippedVertArray[source.length - i - 1] = source[i];
        }
        return flippedVertArray;
    }

    /**
     * Finds the average value of R, G and B for each pixel
     *
     * @param source - file read as int[][][]
     * @return mean, the average of each pixel
     */

    public static double average(int[][][] pixel) {

        // Initalize variables
        long sum = 0;
        long colors = 0;

        // Iterate over array
        for (int i = 0; i < pixel.length; i++) {
            for (int j = 0; j < pixel[0].length; j++) {
                for (int k = 0; k < 3; k++) {

                    // Add pixel value to sum
                    sum += pixel[i][j][k];

                    // Count colors
                    colors++;
                }
            }
        }

        // Solve for mean
        double mean = (double) (sum / colors);

        // Return mean
        return mean;
    }

    /**
     * Binary segmentation, partitions the image into two parts, background (black) and foreground (white)
     *
     * @param source - file read as int[][][]
     * @return mean, the average of each pixel
     */

    public static int[][][] segement(int[][][] source) {

        // Initialize array and call average function
        int[][][] segmentArray = new int[source.length][source[0].length][3];
        double average = average(source);

        // Iterate through the array and find the average color of the pixel
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                int pixel = 0;

                for (int k = 0; k < 3; k++) {
                    pixel += source[i][j][k];
                }

                double averagePixel = ((double) pixel) / 3;

                // Partition into foreground if the average value is greater than the average of the source
                if (averagePixel > average) {
                    for (int k = 0; k < 3; k++) {
                        segmentArray[i][j][k] = 255;
                    }
                } else {
                    for (int k = 0; k < 3; k++) {
                        segmentArray[i][j][k] = 0;
                    }
                }
            }
        }

        // Return segmented image
        return segmentArray;
    }

    /**
     * Returns scaled image, resized
     *
     * @param source - file read as int[][][], int width, int height
     * @return int[][][] scaledImage, resized to given width and height
     */

    public static int[][][] scale(int[][][] source, int width, int height) {

        // Initialize difference variables
        double heightDifference = source.length / ((double) height);
        double widthDifference = source[0].length / ((double) width);

        // Initialize array
        int[][][] scaledImage = new int[height][width][3];

        // Iterate through the array
        for (int i = 0; i < scaledImage.length; i++) {
            for (int j = 0; j < scaledImage[0].length; j++) {

                // Rescale
                scaledImage[i][j] = source[(int) (i * heightDifference)][(int) (j * widthDifference)];
            }
        }

        // Return rescaled image
        return scaledImage;
    }

    /**
     * Blend images
     *
     * @param pixel1 - array of rgb values, pixel2 - array of rgb values, double alpha
     * @return blendedArray, the array of the blended pixels
     */

    public static int[] blend(int[] pixel1, int[] pixel2, double alpha) {

        // Initialize blended pixel
        int[] blendedArray = new int[3];

        // Iterate through pixel RGB values
        for (int i = 0; i < 3; i++) {
            int blendedPixel = (int) ((pixel1[i] * alpha) + (pixel2[i] * (1 - alpha)));
            blendedArray[i] = blendedPixel;
        }

        // Return blended array
        return blendedArray;
    }

    /**
     * Combines images, assuming target is sized to source
     *
     * @param source1 - file read as int[][][], source2 - file read as int[][][], alpha value
     * @return combinedImage
     */

    public static int[][][] combine(int[][][] source1, int[][][] source2, double alpha) {

        // Initialize array
        int[][][] combinedImage = new int[source2.length][source2[0].length][3];

        // Iterate over array
        for (int i = 0; i < source2.length; i++) {
            for (int j = 0; j < source2[0].length; j++) {

                // Blend images into a combined image
                combinedImage[i][j] = blend(source1[i][j], source2[i][j], alpha);
            }
        }

        // Return combined image
        return combinedImage;
    }

    /**
     * Morph the images over n-steps
     *
     * @param source - file read as int[][][], target - file read as int[][][], int n (steps)
     * @return the combined images over n-steps, gradually morphing from the source to the target
     */

    public static void morph(int[][][] source, int[][][] target, int n) {

        // Initialize scaled array
        int[][][] scaledTarget = scale(target, source[0].length, source.length);

        // Process n steps of morph
        for (int i = 0; i <= n; i++) {
            double alpha = (n - i) / (double) n;

            // Show morphed image
            show(combine(source, target, alpha));
        }
    }
}




