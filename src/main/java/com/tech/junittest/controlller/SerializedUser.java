package com.tech.junittest.controlller;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table
public class SerializedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private byte[] byteStream;

    public byte[] getByteStream() {
        return byteStream;
    }

    public void setByteStream(byte[] byteStream) {
        this.byteStream = byteStream;
    }

    public SerializedUser(byte[] serializedUser) {
        this.byteStream = serializedUser;
    }

    public SerializedUser() {
    }
}
