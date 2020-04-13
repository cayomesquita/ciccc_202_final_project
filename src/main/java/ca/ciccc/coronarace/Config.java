package ca.ciccc.coronarace;

import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;

import java.util.Random;

public final class Config {

    private Config() {}

    // GAME VARIABLES
        public static final String TITLE_CORONA_RACE = "Corona Race",
                                   VERSION           = "0.1",
                                   APP_ICON          = "appIcon.png";

    // GENERAL VARIABLES
        private static final int    WIDTH           = 600  ,
                                    HEIGHT          = 600  ;
        private static       int    LEVEL           = 0    ;
        public static final  double nPositionsX     = 4    ,
                                    xLeft           = 100  ,
                                    xCenterL        = 200  ,
                                    xCenterR        = 300  ,
                                    xRight          = 400  ,
                                    WIDTH_PERCENT   = 0.025,
                                    HEIGHT_PERCENT  = 0.2  ;
        private static      String  IMAGE_PATH      = "";
        // SETTER
            public static void      setLEVEL         (int     setLEVEL)      { LEVEL       = setLEVEL;      }
            public static void      setIMAGE_PATH    (String  setIMAGE_PATH) { IMAGE_PATH  = setIMAGE_PATH; }
        // GETTER
            public static int       getWIDTH         () { return WIDTH;          }
            public static int       getHEIGHT        () { return HEIGHT;         }
            public static double    getnPositionsX   () { return nPositionsX;    }
            public static double    getXLeft         () { return xLeft;          }
            public static double    getXCenterL      () { return xCenterL;       }
            public static double    getXCenterR      () { return xCenterR;       }
            public static double    getXRight        () { return xRight;         }
            public static double    getWIDTH_PERCENT () { return WIDTH_PERCENT;  }
            public static double    getHEIGHT_PERCENT() { return HEIGHT_PERCENT; }
            public static int       getLevel         () { return LEVEL; }
            public static String    getImagePath     () { return IMAGE_PATH; }

    // STREET VARIABLES
        public static final double  STREETLINE_DISTANCE_PERCENT = 0.75,
                                    STREET_SPEED      = 50.0;
        public static       double  DISTANCE_OBJECT   = 240,
                                    POSITION_X_OBJECT = 0,
                                    POSITION_Y_OBJECT = 0;
        public static void   setPOSITION_X_OBJECT (double setPOSITION_X_OBJECT) { POSITION_X_OBJECT = setPOSITION_X_OBJECT; }
        public static void   setPOSITION_Y_OBJECT (double setPOSITION_Y_OBJECT) { POSITION_Y_OBJECT = setPOSITION_Y_OBJECT; }
        public static void   setDISTANCE_OBJECT   (double setDISTANCE_OBJECT)   { DISTANCE_OBJECT   = setDISTANCE_OBJECT;   }
        public static double getPositionXObject   ()                            { return POSITION_X_OBJECT; }
        public static double getPositionYObject   ()                            { return POSITION_Y_OBJECT; }
        public static double getDistanceObject    ()                            { return DISTANCE_OBJECT;   }

    // COMPLEMENTS VARIABLES
        public static       double  DISTANCE_COMPLEMENT     = 0  ,
                                    POSITION_X_COMPLEMENT   = 0  ,
                                    POSITION_Y_COMPLEMENT   = 0  ,
                                    N_TREES                 = 100,
                                    nComplementsX           = 2  ,
                                    ComplementLeft          = 15 ,
                                    ComplementRight         = 510;
        // SETTER
            public static void   setDISTANCE_COMPLEMENT   (double setDISTANCE_COMPLEMENT)   { DISTANCE_COMPLEMENT   = setDISTANCE_COMPLEMENT;   }
            public static void   setPOSITION_X_COMPLEMENT (double setPOSITION_X_COMPLEMENT) { POSITION_X_COMPLEMENT = setPOSITION_X_COMPLEMENT; }
            public static void   setPOSITION_Y_COMPLEMENT (double setPOSITION_Y_COMPLEMENT) { POSITION_Y_COMPLEMENT = setPOSITION_Y_COMPLEMENT; }
            public static void   setN_TREES               (double setN_TREES)               { N_TREES               = setN_TREES;               }
        // GETTER
            public static double getDistanceComplement    ()                                { return DISTANCE_COMPLEMENT;   }
            public static double getPositionXComplement   ()                                { return POSITION_X_COMPLEMENT; }
            public static double getPositionYComplement   ()                                { return POSITION_Y_COMPLEMENT; }
            public static double getN_Trees               ()                                { return N_TREES;               }
            public static double getComplementsX          ()                                { return nComplementsX;         }
            public static double getComplementLeft        ()                                { return ComplementLeft;        }
            public static double getComplementRight       ()                                { return ComplementRight;       }

    // PLAYER VARIABLES


    // MEDICINE VARIABLES
        private static int     N_MEDICINES = 2;
        // SETTER
            public static void setN_MEDICINES(int setN_MEDICINE){ N_MEDICINES = setN_MEDICINE; }
        // GETTER
            public static int  getN_Medicines()                 { return N_MEDICINES; }

    // ENEMY VARIABLES
        private static double   ENEMY_HEIGHT = 60,
                                ENEMY_WIDTH  = 45,
                                MAX_ENEMIES  = 0;
        // SETTER
            public static void   setENEMY_HEIGHT(double setENEMY_HEIGHT){ ENEMY_HEIGHT = setENEMY_HEIGHT; }
            public static void   setENEMY_WIDTH (double setENEMY_WIDTH) { ENEMY_WIDTH  = setENEMY_WIDTH;  }
            public static void   setMAX_ENEMIES (double setMAX_ENEMIES) { MAX_ENEMIES  = setMAX_ENEMIES;  }
        // GETTER
            public static double getEnemyHeight ()                      { return ENEMY_HEIGHT; }
            public static double getEnemyWidth  ()                      { return ENEMY_WIDTH; }
            public static double getMaxEnemies  ()                      {
                switch (LEVEL){
                    case 1: MAX_ENEMIES = 30; break;
                    case 2: MAX_ENEMIES = 40; break;
                    case 3: MAX_ENEMIES = 50; break;
                    case 4: MAX_ENEMIES = 60; break;
                    case 5: MAX_ENEMIES = 70; break;
                }
                return MAX_ENEMIES;
            }

    // HELPER METHODS
    public static Random nRandom = new Random();
    public static int getNRandom(double maxNum){
        return nRandom.nextInt((int)maxNum);
    }
}
