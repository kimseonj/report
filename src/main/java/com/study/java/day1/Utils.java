package com.study.java.day1;

import com.study.java.day1.domain.music.BackgroundMusic;

import java.io.IOException;

import static com.study.java.day1.CLIProgram.br;

public class Utils {

    private static BackgroundMusic backgroundMusic = new BackgroundMusic();

    static {
        backgroundMusic.inputMusic("drift-away-dusk-fss-no-copyright-music-234393.wav");
    }

    /**
     * 파라미터 maxNumber로 몇번을 고르는지 검증해줍니다.
     * <p>
     * 숫자를 고르고, 검증하는 로직이 너무 많아서 따로 뺐습니다.
     * @return
     */
    public static int validationNumber() {
        String input = "";
        while (true) {
            try {
                input = br.readLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                if (input.equals("ON")) {
                    backgroundMusic.playMusic();
                    System.out.println("배경음악이 켜졌습니다.");

                    System.out.print("숫자를 입력해주세요! : ");
                } else if (input.equals("OFF")){
                    backgroundMusic.stopMusic();
                    System.out.println("배경음악이 껴졌습니다.");

                    System.out.print("숫자를 입력해주세요! : ");
                } else {
                    System.out.print("숫자를 입력해주세요! : ");
                }
            } catch (IOException e) {
                System.out.print("숫자를 입력해주세요! : ");
            }
        }
    }
}
