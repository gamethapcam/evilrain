/*
 *   Copyright(c) 2001-2012, Latista Technologies Inc, All Rights Reserved.
 *
 *   The software and information contained herein are copyrighted and
 *   proprietary to Latista Technologies Inc. This software is furnished
 *   pursuant to a written license agreement and may be used, copied,
 *   transmitted, and stored only in accordance with the terms of such
 *   license and with the inclusion of the above copyright notice. Please
 *   refer to the file "LICENSE" for further copyright and licensing
 *   information. This software and information or any other copies
 *   thereof may not be provided or otherwise made available to any other
 *   person.
 *
 *   LATISTA TECHNOLOGIES INC MAKES NO REPRESENTATIONS AND EXTENDS NO
 *   WARRANTIES, EXPRESS OR IMPLIED, WITH RESPECT TO THE SOFTWARE, INCLUDING,
 *   BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 *   FOR ANY PARTICULAR PURPOSE, AND THE WARRANTY AGAINST INFRINGEMENT OF
 *   PATENTS OR OTHER INTELLECTUAL PROPERTY RIGHTS. THE SOFTWARE IS PROVIDED
 *   "AS IS", AND IN NO EVENT SHALL LATISTA TECHNOLOGIES INC OR ANY OF ITS
 *   AFFILIATES BE LIABLE FOR ANY DAMAGES, INCLUDING ANY LOST PROFITS OR OTHER
 *   INCIDENTAL OR CONSEQUENTIAL DAMAGES RELATING TO THE SOFTWARE.
 *
 *   Please note that this software and information are protected by copyright
 *   law and international treaties. Unauthorized use, copy and/or modification
 *   of this software and information, may result in severe civil and criminal
 *   penalties, and will be prosecuted to the maximum extent possible under the
 *   law.
 */
package com.alex.rain.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.*;

/**
 * @author: Alexander Shubenkov
 * @since: 05.07.13
 */

public class TextureManager {
    private Map<String, Texture> textureMap = new HashMap<String, Texture>();
    private static TextureManager manager = new TextureManager();
    
    private TextureManager() {}

    public static TextureManager getInstance() {
        return manager;
    }

    public Texture getTexture(String path) {
        if(textureMap.containsKey(path)) {
            return textureMap.get(path);
        } else {
            Texture texture = new Texture(Gdx.files.internal("data/" + path));
            textureMap.put(path, texture);
            return texture;
        }
    }
}