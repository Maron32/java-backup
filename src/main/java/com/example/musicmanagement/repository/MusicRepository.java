package com.example.musicmanagement.repository;

import com.example.musicmanagement.entity.Music;
import com.example.musicmanagement.mapper.MusicMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusicRepository {
    private final MusicMapper musicMapper;

    public MusicRepository(MusicMapper musicMapper) {
        this.musicMapper = musicMapper;
    }

    public List<Music> getMusicsByAlbumId( long albumId){
        return musicMapper.selectMusicAlbumById(albumId);
    }

    public void insertMusic(Music music){
        musicMapper.insertMusic(music);
    }

    public void deleteMusicById(long musicId){
        musicMapper.deleteMusicById(musicId);
    }

    public  void updateMusic(Music music){
        musicMapper.updateMusic(music);
    }

    public Music selectMusicById(long musicId){
        return musicMapper.selectMusicById(musicId);
    }
}
