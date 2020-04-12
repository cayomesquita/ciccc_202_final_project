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
    public static final int  WIDTH  = 600;
    public static final int  HEIGHT = 600;
    private static int  N_MEDICINES = 2,
                        LEVEL       = 0;
    public static int        getLevel      ()                  { return LEVEL; }
    public static int        getN_Medicines()                  { return N_MEDICINES; }
    public static void       setLEVEL      (int setLEVEL)      { LEVEL = setLEVEL; }
    public static void       setN_MEDICINES(int setN_MEDICINE) { N_MEDICINES = setN_MEDICINE; }

    private static       double  nPositionsX     = 4,
                                 xLeft           = 100,
                                 xCenterL        = 200,
                                 xCenterR        = 300,
                                 xRight          = 400;
    public static double getnPositionsX () { return nPositionsX; }
    public static double getXLeft       () { return xLeft; }
    public static double getXCenterL    () { return xCenterL; }
    public static double getXCenterR    () { return xCenterR; }
    public static double getXRight      () { return xRight; }

    // STREET VARIABLES
    public static final double  STREETLINE_DISTANCE_PERCENT = 0.75;
    public static final double  STREET_SPEED      = 100.0;
    public static       double  DISTANCE_OBJECT   = 200,
                                POSITION_X_OBJECT = 0,
                                POSITION_Y_OBJECT = 0;
    public static void setPOSITION_X_OBJECT (double setPOSITION_X_OBJECT) { POSITION_X_OBJECT = setPOSITION_X_OBJECT; }
    public static void setPOSITION_Y_OBJECT (double setPOSITION_Y_OBJECT) { POSITION_Y_OBJECT = setPOSITION_Y_OBJECT; }
    public static void setDISTANCE_OBJECT   (double setDISTANCE_OBJECT)   { DISTANCE_OBJECT   = setDISTANCE_OBJECT;   }
    public static double getPositionXObject ()                            { return POSITION_X_OBJECT; }
    public static double getPositionYObject ()                            { return POSITION_Y_OBJECT; }
    public static double getDistanceObject  ()                            { return DISTANCE_OBJECT;   }

    // ENEMY VARIABLES
    private static double   ENEMY_HEIGHT    = 100,
                            ENEMY_WIDTH     = 100,
                            MAX_ENEMIES     = 0;
    public static void setENEMY_HEIGHT     (double setENEMY_HEIGHT)     { ENEMY_HEIGHT     = setENEMY_HEIGHT;     }
    public static void setENEMY_WIDTH      (double setENEMY_WIDTH)      { ENEMY_WIDTH      = setENEMY_WIDTH;      }
    public static void setMAX_ENEMIES      (double setMAX_ENEMIES)      { MAX_ENEMIES      = setMAX_ENEMIES;      }
    public static double getEnemyHeight()    { return ENEMY_HEIGHT; }
    public static double getEnemyWidth()     { return ENEMY_WIDTH; }
    public static double getMaxEnemies() {
        switch (LEVEL){
            case 1: MAX_ENEMIES = 20; break;
            case 2: MAX_ENEMIES = 30; break;
            case 3: MAX_ENEMIES = 40; break;
            case 4: MAX_ENEMIES = 50; break;
            case 5: MAX_ENEMIES = 60; break;
        }
        return MAX_ENEMIES;
    }
}
