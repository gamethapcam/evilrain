/*******************************************************************************
 * Copyright 2013 See AUTHORS file.
 *
 * Licensed under the GNU GENERAL PUBLIC LICENSE V3
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.gnu.org/licenses/gpl.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.alex.rain.managers;

import com.alex.rain.models.Ground;
import com.alex.rain.models.SimpleActor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class ExportManager {
    private Stage stage;
    private String onCreateStr, onCheckStr, onBeginContactStr, onEndContactStr;

    public ExportManager(Stage stage, String onCreateStr, String onCheckStr, String onBeginContactStr,
                String onEndContactStr) {
        this.stage = stage;
        this.onCreateStr = onCreateStr;
        this.onCheckStr = onCheckStr;
        this.onBeginContactStr = onBeginContactStr;
        this.onEndContactStr = onEndContactStr;
    }

    public String export() {
        String accum = "function addObjects()\n";

        for(Actor a : stage.getRoot().getChildren()) {
            if(!(a instanceof SimpleActor))
                continue;

            SimpleActor sa = (SimpleActor) a;
            accum += exportActor(sa);
        }

        accum += "end\n" +
                "function onCreate()\n" +
                (onCreateStr != null && onCreateStr.length() > 0 ? onCreateStr : "    addObjects()\n") +
                "end\n" +
                "function onBeginContact(contact)\n" +
                (onBeginContactStr != null ? onBeginContactStr : "") +
                "end\n" +
                "function onEndContact(contact)\n" +
                (onEndContactStr != null ? onEndContactStr : "") +
                "end\n" +
                "function onCheck()\n" +
                (onCheckStr != null ? onCheckStr : "") +
                "end";



        return accum;
    }

    public String exportActor(SimpleActor sa) {
        String s = "    ------------------\n";
        String name = sa.getName() == null ? "obj" : sa.getName();
        s += "    " + name + " = luajava.new(" + sa.getClass().getSimpleName() + ")\n";
        switch(sa.getType()) {
            case GROUND:
                for(Vector2 v : ((Ground)sa).getVertices())
                s += "    " + name + ":addVertex(" + v.x + ", " + v.y + ")\n";
                break;
        }

        if(s.isEmpty())
            return "    --Error import " + sa + "\n\n";
        else {
            s += "    " + name + ":" + (sa.getType() == SimpleActor.TYPE.GROUND ? "addTo" : "set") + "Position(" +
                    (sa.getX() + sa.getWidth() / 2) + ", " + (sa.getY() + sa.getHeight() / 2) + ")\n";
            s += "    " + name + ":setRotation(" + sa.getRotation() + ")\n";
            if(sa.getBodyType() != null) {
                s += "    " + name + ":setBodyType(";
                switch(sa.getBodyType()) {
                    case DynamicBody:
                        s += "DYNAMIC_BODY";
                        break;
                    case StaticBody:
                        s += "STATIC_BODY";
                        break;
                    case KinematicBody:
                        s += "KINEMATIC_BODY";
                        break;
                }
                s += ")\n";
            }
            if(sa.getName() != null)
                s += "    " + name + ":setName('" + sa.getName() + "')\n";
            s += "    " + name + ":setVisible(" + sa.isVisible() + ")\n";
            s += "    world:add(" + name + ")\n\n";
            return s;
        }
    }
}
