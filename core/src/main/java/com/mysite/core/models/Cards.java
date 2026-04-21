package com.mysite.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sling Model – Album Cards Component
 *
 * Itera sobre el multifield "cards" almacenado como nodos hijo,
 * y expone una lista de {@link CardItem} al HTL.
 */
@Model(
    adaptables   = SlingHttpServletRequest.class,
    adapters     = {Cards.class, ComponentExporter.class},
    resourceType = Cards.RESOURCE_TYPE,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(
    name       = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
    extensions = ExporterConstants.SLING_MODEL_EXTENSION
)
public class Cards implements ComponentExporter {

    public static final String RESOURCE_TYPE = "myproject/components/content/album-cards";

    /** Nodos hijo del multifield "cards" */
    @ChildResource
    private List<Resource> cards;

    private List<CardItem> cardItems = new ArrayList<>();

    @PostConstruct
    protected void init() {
        if (cards != null) {
            for (Resource cardResource : cards) {
                cardItems.add(new CardItem(cardResource));
            }
        }
    }

    public List<CardItem> getCards()   { return Collections.unmodifiableList(cardItems); }
    public boolean isEmpty()           { return cardItems.isEmpty(); }

    @Override
    public String getExportedType()    { return RESOURCE_TYPE; }

    // ── Inner class: CardItem ─────────────────────────────────────────────────

    /**
     * Representa una tarjeta individual del componente.
     */
    public static class CardItem {

        private final String imageUrl;
        private final String imageAlt;
        private final String description;
        private final String viewLink;
        private final String editLink;
        private final String readingTime;

        public CardItem(Resource resource) {
            var vm    = resource.getValueMap();
            imageUrl    = vm.get("imageUrl",    String.class);
            imageAlt    = vm.get("imageAlt",    "");
            description = vm.get("description", String.class);
            viewLink    = vm.get("viewLink",    String.class);
            editLink    = vm.get("editLink",    String.class);
            readingTime = vm.get("readingTime", String.class);
        }

        public String getImageUrl()    { return imageUrl; }
        public String getImageAlt()    { return StringUtils.defaultIfBlank(imageAlt, ""); }
        public String getDescription() { return description; }
        public String getViewLink()    { return StringUtils.defaultIfBlank(viewLink, "#"); }
        public String getEditLink()    { return StringUtils.defaultIfBlank(editLink, "#"); }
        public String getReadingTime() { return readingTime; }
    }
}