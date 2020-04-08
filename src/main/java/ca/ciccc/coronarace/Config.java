/*
 * The MIT License (MIT)
 *
 * FXGL - JavaFX Game Library
 *
 * Copyright (c) 2015-2017 AlmasB (almaslvl@gmail.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package ca.ciccc.coronarace;

/**
 * @author Almas Baimagambetov (AlmasB) (almaslvl@gmail.com)
 */
public final class Config {

    private Config() {}

    // GAME VARIABLES
    public static final String TITLE_CORONA_RACE = "Corona Race";
    public static final String VERSION = "0.1";

    // GENERAL VARIABLES
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    public static final int LEVEL = 1;

    // STREET VARIABLES
    public static final double STREETLINE_DISTANCE_PERCENT = 0.75;
    public static final double STREET_SPEED = 20.0;

    // ENEMY VARIABLES

    public static final double  WIDTH_PERCENT       = 0.025,
                                HEIGHT_PERCENT      = 0.2,
                                xLeft               =  Config.WIDTH * (1 - WIDTH_PERCENT) / 3,        //  600 * (1 - .025) / 2;       = 195
                                xCenter             =  Config.WIDTH * (1 - WIDTH_PERCENT) / 2,        //  600 * (1 - .025) / 2;       = 292.5
                                xRight              = (Config.WIDTH * (1 - WIDTH_PERCENT) / 3) * 2,   // (600 * (1 - .025) / 2) * 2;  = 390
                                ENEMY_HEIGHT        = 50,
                                ENEMY_WIDTH         = 50,
                                ENEMY_DISTANCE      = 150,
                                ENEMIES_LEVEL_ONE   = 10;

}
