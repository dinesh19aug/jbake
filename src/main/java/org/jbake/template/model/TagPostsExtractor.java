package org.jbake.template.model;

import java.util.List;
import java.util.Map;

import org.jbake.app.ContentStore;
import org.jbake.app.Crawler;
import org.jbake.app.DocumentList;
import org.jbake.template.ModelExtractor;

import com.orientechnologies.orient.core.record.impl.ODocument;

public class TagPostsExtractor implements ModelExtractor<DocumentList> {

	@Override
	public DocumentList get(ContentStore db, Map model, String key) {
        String tag = null;
		if (model.get(Crawler.Attributes.TAG) != null) {
			tag = model.get(Crawler.Attributes.TAG).toString();
		}
        // fetch the tag posts from db
        List<ODocument> query = db.getPublishedPostsByTag(tag);
        return DocumentList.wrap(query.iterator());
	}

}