/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.exception;

/**
 *
 * @author mike
 */
public class NotFoundObjectException extends RuntimeException{
    public NotFoundObjectException(String message){
        super(message);
    }
}
