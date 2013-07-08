function onCreate(world)
    drop = luajava.newInstance(Drop)
    world:add(drop)
    drop:setPosition(luajava.newInstance(Vector2, 100, 400))

    for i = 0, 19 do
        for j = 0, 9 do
            drop = luajava.newInstance(Drop)
            world:add(drop)
            drop:setPosition(luajava.newInstance(Vector2, i * 15 + 130, j * 15 + 140))
        end
    end

    ground = luajava.newInstance(Ground)
    ground:addVertex(752, 48)
    ground:addVertex(752, 344)
    ground:addVertex(696, 208)
    ground:addVertex(600, 208)
    ground:addVertex(504, 136)
    ground:addVertex(272, 152)
    ground:addVertex(96, 136)
    ground:addVertex(32, 360)
    ground:addVertex(32, 32)
    world:add(ground)

    dynamicActor = luajava.newInstance(DynamicActor)
    world:add(dynamicActor)
    dynamicActor:setPosition(luajava.newInstance(Vector2, 650, 300))

    for i = 0, 5 do
        dynamicActorTmp = luajava.newInstance(DynamicActor)
        dynamicActorTmp:setBodyBox(20, 20 + i * 10)
        dynamicActorTmp:setSpriteBox(20, 20 + i * 10)
        world:add(dynamicActorTmp)
        dynamicActorTmp:setPosition(luajava.newInstance(Vector2, 100 + i * 40, 300))
    end

    cloud = luajava.newInstance(Cloud)
    world:add(cloud)
    cloud:setPosition(luajava.newInstance(Vector2, 650, 420))
end

function onCheck(mArray)
    if dynamicActor:getRotation() < -30 or dynamicActor:getRotation() > 30 then
        return true
    end

    return false
end