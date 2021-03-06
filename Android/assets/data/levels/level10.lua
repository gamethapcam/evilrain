dynActorArray = {}

function onCreate()
    world:setPressingAction(PICKING_BODIES);

    local ground = luajava.new(Ground)
    ground:addVertex(48, 300)
    ground:addVertex(48, 48)
    ground:addVertex(320, 48)
    ground:addVertex(320, 300)
    ground:addVertex(296, 300)
    ground:addVertex(296, 72)
    ground:addVertex(72, 72)
    ground:addVertex(72, 300)
    world:add(ground)

    local ground = luajava.new(Ground)
    ground:addVertex(320, 200)
    ground:addVertex(320, 220)
    ground:addVertex(48, 220)
    ground:addVertex(48, 200)
    world:add(ground)

    local cloud = luajava.new(Cloud)
    cloud:setPosition(luajava.new(Vector2, 600, 420))
    world:add(cloud)
    cloud:setMinMaxPosRectangle(0, 300, 800, 200)

    trigger = luajava.new(Trigger)
    trigger:setBodyType(KINEMATIC_BODY)
    trigger:setPosition(luajava.new(Vector2, 222, 160))
    world:add(trigger)
    table.insert(dynActorArray, trigger)

    trigger = luajava.new(Trigger)
    trigger:setBodyType(KINEMATIC_BODY)
    trigger:setPosition(luajava.new(Vector2, 568, 160))
    world:add(trigger)
    table.insert(dynActorArray, trigger)

    trigger:setListener(luajava.createProxy(IEventListener, {
        handle = function (e)
            ground:addToPosition(0, 100)
        end,
    }))
end

function onCheck()
    for i = 1, #dynActorArray do
        if dynActorArray[i]:getState() == false then
            return false
        end
    end

    return true
end
