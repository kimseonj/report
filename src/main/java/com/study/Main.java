package com.study;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        Test test = new Test();
        test.playMusic();
    }


    public static class Test {
        public void playMusic() throws LineUnavailableException, IOException, InterruptedException {

            String musicName = "drift-away-dusk-fss-no-copyright-music-234393.wav";
            URL resource = getClass().getClassLoader().getResource(musicName);
            AudioInputStream b;

            {
                try {
                    b = AudioSystem.getAudioInputStream(resource);
                } catch (UnsupportedAudioFileException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            Clip c;

            {
                try {
                    c = AudioSystem.getClip();
                } catch (LineUnavailableException e) {
                    throw new RuntimeException(e);
                }
            }

            c.open(b);
            c.start();

            Thread.sleep(c.getMicrosecondLength() / 1000);
        }

    }
}
