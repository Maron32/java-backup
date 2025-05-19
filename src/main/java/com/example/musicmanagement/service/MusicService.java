package com.example.musicmanagement.service;

import com.example.musicmanagement.entity.Music;
import com.example.musicmanagement.form.MusicForm;
import com.example.musicmanagement.mapper.MusicMapper;
import com.example.musicmanagement.repository.AlbumRepository;
import com.example.musicmanagement.repository.MusicRepository;
import com.example.musicmanagement.viewmodel.AlbumViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {
    private final MusicRepository musicRepository;
    private final AlbumRepository albumRepository;

    public MusicService(MusicRepository musicRepository, AlbumRepository albumRepository) {
        this.musicRepository = musicRepository;
        this.albumRepository = albumRepository;
    }
    public List<Music> getMusicsByAlbumId(long albumId) {
        return musicRepository.getMusicsByAlbumId(albumId);
    }

    public void createMusic(MusicForm musicForm){
        Music music = new Music();
        music.setAlbumId(musicForm.getAlbumId());
        music.setTitle(musicForm.getTitle());
        music.setDuration(musicForm.getDuration());

        musicRepository.insertMusic(music);
    }

    public void deleteMusicById(long musicId){
        musicRepository.deleteMusicById(musicId);
    }

    public Music getMusicById(long musicId){
        return musicRepository.selectMusicById(musicId);
    }

    public void updateMusic(long musicId, Music music){
        if(musicId != music.getMusicId()){
            throw new IllegalArgumentException("Music ID does not match");
        }
        musicRepository.updateMusic(music);
    }
}
