package com.alex.rain.models;

import com.alex.rain.managers.TextureManager;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * @author: Alexander Shubenkov
 * @since: 16.07.13
 */

public class Home extends DynamicActor {
    public Home() {
        sprite = TextureManager.getInstance().getSpriteFromDefaultAtlas("home1");
        setBodyBox(32, 100);
    }

    @Override
    public void createPhysicsActor(World physicsWorld) {
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(getPhysicsWidth() / 2, getPhysicsHeight() / 2);
        offset.set(-getWidth() / 2, -getHeight() / 2);
        sprite.setOrigin(getWidth() / 2, getHeight() / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = polygonShape;
        fixtureDef.density = 2;
        fixtureDef.friction = 1f;

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = physicsWorld.createBody(bodyDef);
        body.createFixture(fixtureDef);
        body.resetMassData();

        polygonShape.dispose();
    }
}
