package com.study.java.day1.domain.music;


import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class BackgroundMusic {
    private ArrayList<Music> playList = new ArrayList<>();
    private Thread mp3Thread;
    private Clip clip;

    private boolean isPlaying = false;

    public void inputMusic(String musicName) {
        playList.add(new Music(musicName));
    }

    /**
     * 음악 재생 메서드
     */
    public void playMusic() {
        if (playList.isEmpty()) {
            System.out.println("재생 할 음악이 없습니다.");
            return;
        }
        if (isPlaying) {
            System.out.println("현재 배경음악이 재생 중입니다.");
            return;
        }

        mp3Thread = new Thread(() -> {
            Music music = playList.getFirst();
            URL resource = getClass().getClassLoader().getResource(music.getMusicName());

            // 음악 재생
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(resource);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (UnsupportedAudioFileException | IOException | RuntimeException | LineUnavailableException e) {
                throw new RuntimeException(e);
            }
        });

        isPlaying = true;
        mp3Thread.start();
    }

    /**
     * 음악 멈춤 메서드
     */
    public void stopMusic() {
        if (!isPlaying) {
            System.out.println("배경음악은 꺼져있습니다.");
            return;
        }
        mp3Thread.interrupt();
        clip.stop();
        clip.close();
        isPlaying = false;
    }
}
