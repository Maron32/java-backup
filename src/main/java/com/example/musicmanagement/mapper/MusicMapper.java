package com.example.musicmanagement.mapper;

import com.example.musicmanagement.entity.Album;
import com.example.musicmanagement.entity.Music;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MusicMapper {
    @Select("SELECT * FROM musics WHERE album_id = #{albumId}")
    List<Music> selectMusicAlbumById(long albumId);

    @Insert("INSERT INTO musics(title,duration,album_Id) VALUES (#{title}, #{duration}, #{albumId})")
    @Options(useGeneratedKeys = true, keyProperty = "musicId")
    void insertMusic(Music music);

    @Delete("DELETE FROM musics WHERE music_id = #{musicId}")
    void deleteMusicById(long musicId);

    @Update("UPDATE musics SET title=#{title}, duration=#{duration} WHERE music_id = #{musicId}")
    void updateMusic(Music music);

    @Select("SELECT * FROM musics WHERE music_id = #{musicId}")
    Music selectMusicById(long musicId);


}
