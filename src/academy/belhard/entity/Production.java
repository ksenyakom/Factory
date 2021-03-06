package academy.belhard.entity;

import academy.belhard.util.TimestampUtil;

import java.sql.Timestamp;

public class Production {
    private int id;
    private String name;
    private String code;
    private int volume;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    private Production(String name, String code, int volume) {
        this.name = name;
        this.code = code;
        this.volume = volume;
    }




    public Production(int id, String name, String code, int volume, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.volume = volume;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Production createItemForSaving(String name, String code, int volume) {
        return new Production( name,  code,  volume);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Production{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", volume=" + volume +" ml" +
                ", createdAt=" + TimestampUtil.toString(createdAt) +
                ", updatedAt=" + TimestampUtil.toString(updatedAt) +
                '}';
    }
}
