function onCreate()
    world:setPressingAction(DRAWING);
    ------------------
    Ground_0 = luajava.new(Ground)
    Ground_0:addVertex(145.99998, 124.999985)
    Ground_0:addVertex(154.0, 157.0)
    Ground_0:addVertex(169.0, 167.0)
    Ground_0:addVertex(190.99998, 175.0)
    Ground_0:addVertex(219.0, 170.0)
    Ground_0:addVertex(235.99998, 165.0)
    Ground_0:addVertex(246.0, 142.0)
    Ground_0:addVertex(251.0, 126.999985)
    Ground_0:addVertex(274.0, 154.0)
    Ground_0:addVertex(296.0, 169.0)
    Ground_0:addVertex(324.0, 171.99998)
    Ground_0:addVertex(356.0, 162.0)
    Ground_0:addVertex(364.0, 130.0)
    Ground_0:addVertex(364.0, 95.00001)
    Ground_0:addVertex(341.99997, 69.999985)
    Ground_0:addVertex(302.0, 62.0)
    Ground_0:addVertex(269.0, 72.0)
    Ground_0:addVertex(252.0, 91.99999)
    Ground_0:addVertex(239.00002, 69.999985)
    Ground_0:addVertex(199.0, 55.0)
    Ground_0:addVertex(163.99998, 62.0)
    Ground_0:addVertex(145.99998, 82.0)
    Ground_0:addVertex(145.99998, 104.0)
    Ground_0:addVertex(129.0, 104.0)
    Ground_0:addVertex(131.0, 66.99999)
    Ground_0:addVertex(156.0, 39.999996)
    Ground_0:addVertex(190.99998, 37.0)
    Ground_0:addVertex(233.99998, 37.0)
    Ground_0:addVertex(257.0, 57.0)
    Ground_0:addVertex(276.0, 32.0)
    Ground_0:addVertex(329.0, 34.0)
    Ground_0:addVertex(364.0, 62.0)
    Ground_0:addVertex(386.0, 104.0)
    Ground_0:addVertex(377.0, 164.0)
    Ground_0:addVertex(343.99997, 196.99998)
    Ground_0:addVertex(291.99997, 196.99998)
    Ground_0:addVertex(259.0, 171.99998)
    Ground_0:addVertex(236.99998, 192.0)
    Ground_0:addVertex(171.99998, 195.0)
    Ground_0:addVertex(139.0, 184.99998)
    Ground_0:addVertex(127.0, 112.0)
    Ground_0:addVertex(144.0, 109.0)
    Ground_0:setPosition(-50.0, 0.0)
    Ground_0:setRotation(0.0)
    Ground_0:setName('Ground_0')
    Ground_0:setVisible(false)
    world:add(Ground_0)

    ------------------
    Ground_1 = luajava.new(Ground)
    Ground_1:addVertex(216.00002, 133.99998)
    Ground_1:addVertex(199.0, 139.0)
    Ground_1:addVertex(182.0, 137.0)
    Ground_1:addVertex(174.0, 119.99999)
    Ground_1:addVertex(179.0, 99.999985)
    Ground_1:addVertex(195.99998, 91.99999)
    Ground_1:addVertex(219.0, 109.0)
    Ground_1:setPosition(-50.0, 0.0)
    Ground_1:setRotation(0.0)
    Ground_1:setName('Ground_1')
    Ground_1:setVisible(false)
    world:add(Ground_1)

    ------------------
    Ground_2 = luajava.new(Ground)
    Ground_2:addVertex(326.0, 126.999985)
    Ground_2:addVertex(304.0, 133.99998)
    Ground_2:addVertex(284.0, 119.99999)
    Ground_2:addVertex(293.99997, 97.0)
    Ground_2:addVertex(316.0, 91.99999)
    Ground_2:addVertex(331.0, 106.99999)
    Ground_2:setPosition(-50.0, 0.0)
    Ground_2:setRotation(0.0)
    Ground_2:setName('Ground_2')
    Ground_2:setVisible(false)
    world:add(Ground_2)

    trigger_3 = luajava.new(Trigger)
    trigger_3:setPosition(695.57153, 94.48703)
    trigger_3:setRotation(359.9033)
    trigger_3:setName('trigger_3')
    trigger_3:setVisible(true)
    trigger_3:setBodyType(KINEMATIC_BODY)
    world:add(trigger_3)
end

function onCheck()
    local count = world:dropsInRect(90, 50, 230, 120)
    return count > 160
end
