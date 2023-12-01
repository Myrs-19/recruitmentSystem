/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.exception;

/**
 *
 * @author mike
 */
public class NotFoundObjectInFileException extends RuntimeException{
    public NotFoundObjectInFileException(String message){
        super(message);
    }
}
