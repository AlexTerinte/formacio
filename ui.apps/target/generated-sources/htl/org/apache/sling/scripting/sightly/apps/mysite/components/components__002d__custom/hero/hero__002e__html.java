/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.sling.scripting.sightly.apps.mysite.components.components__002d__custom.hero;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class hero__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_model = null;
Object _global_templates = null;
_global_model = renderContext.call("use", com.mysite.core.models.Hero.class.getName(), obj());
_global_templates = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
out.write("\n\n");
{
    Object var_templatevar0 = renderContext.getObjectModel().resolveProperty(_global_templates, "placeholder");
    {
        Object var_templateoptions1_field$_isempty = renderContext.getObjectModel().resolveProperty(_global_model, "title");
        {
            java.util.Map var_templateoptions1 = obj().with("isEmpty", var_templateoptions1_field$_isempty);
            callUnit(out, renderContext, var_templatevar0, var_templateoptions1);
        }
    }
}
out.write("\n \n<section class=\"album-hero\">\n    <div class=\"album-hero__inner\">\n        ");
{
    Object var_testvariable2 = renderContext.getObjectModel().resolveProperty(_global_model, "title");
    if (renderContext.getObjectModel().toBoolean(var_testvariable2)) {
        out.write("<h1 class=\"album-hero__title\">");
        {
            String var_3 = (("\n            " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "title"), "text"))) + "\n        ");
            out.write(renderContext.getObjectModel().toString(var_3));
        }
        out.write("</h1>");
    }
}
out.write("\n        ");
{
    Object var_testvariable4 = renderContext.getObjectModel().resolveProperty(_global_model, "description");
    if (renderContext.getObjectModel().toBoolean(var_testvariable4)) {
        out.write("<p class=\"album-hero__description\">");
        {
            String var_5 = (("\n            " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "description"), "html"))) + "\n        ");
            out.write(renderContext.getObjectModel().toString(var_5));
        }
        out.write("</p>");
    }
}
out.write("\n        ");
{
    Object var_testvariable6 = ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_model, "primaryCtaLabel")) ? renderContext.getObjectModel().resolveProperty(_global_model, "primaryCtaLabel") : renderContext.getObjectModel().resolveProperty(_global_model, "secondaryCtaLabel")));
    if (renderContext.getObjectModel().toBoolean(var_testvariable6)) {
        out.write("<div class=\"album-hero__actions\">\n            ");
        {
            Object var_testvariable7 = renderContext.getObjectModel().resolveProperty(_global_model, "primaryCtaLabel");
            if (renderContext.getObjectModel().toBoolean(var_testvariable7)) {
                out.write("<a class=\"album-hero__btn album-hero__btn--primary\"");
                {
                    Object var_attrvalue8 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "primaryCtaLink"), "uri");
                    {
                        boolean var_shoulddisplayattr11 = ((!"".equals(var_attrvalue8)) && (!((Object)false).equals(var_attrvalue8)));
                        if (var_shoulddisplayattr11) {
                            out.write(" href");
                            {
                                boolean var_istrueattr10 = (var_attrvalue8.equals(true));
                                if (!var_istrueattr10) {
                                    out.write("=\"");
                                    out.write(renderContext.getObjectModel().toString(var_attrvalue8));
                                    out.write("\"");
                                }
                            }
                        }
                    }
                }
                out.write(">");
                {
                    String var_12 = (("\n                " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "primaryCtaLabel"), "text"))) + "\n            ");
                    out.write(renderContext.getObjectModel().toString(var_12));
                }
                out.write("</a>");
            }
        }
        out.write("\n            ");
        {
            Object var_testvariable13 = renderContext.getObjectModel().resolveProperty(_global_model, "secondaryCtaLabel");
            if (renderContext.getObjectModel().toBoolean(var_testvariable13)) {
                out.write("<a class=\"album-hero__btn album-hero__btn--secondary\"");
                {
                    Object var_attrvalue14 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "secondaryCtaLink"), "uri");
                    {
                        boolean var_shoulddisplayattr17 = ((!"".equals(var_attrvalue14)) && (!((Object)false).equals(var_attrvalue14)));
                        if (var_shoulddisplayattr17) {
                            out.write(" href");
                            {
                                boolean var_istrueattr16 = (var_attrvalue14.equals(true));
                                if (!var_istrueattr16) {
                                    out.write("=\"");
                                    out.write(renderContext.getObjectModel().toString(var_attrvalue14));
                                    out.write("\"");
                                }
                            }
                        }
                    }
                }
                out.write(">");
                {
                    String var_18 = (("\n                " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_model, "secondaryCtaLabel"), "text"))) + "\n            ");
                    out.write(renderContext.getObjectModel().toString(var_18));
                }
                out.write("</a>");
            }
        }
        out.write("\n        </div>");
    }
}
out.write("\n    </div>\n</section>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

