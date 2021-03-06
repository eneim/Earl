package com.einmalfel.earl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URI;

public class AtomGenerator extends AtomCommonAttributes {
  static final String XML_TAG = "generator";

  @Nullable
  public final URI uri;
  @Nullable
  public final String version;
  @NonNull
  public final String value;

  @NonNull
  static AtomGenerator read(XmlPullParser parser) throws XmlPullParserException, IOException {
    parser.require(XmlPullParser.START_TAG, null, XML_TAG);
    String uri = parser.getAttributeValue(XmlPullParser.NO_NAMESPACE, "uri");
    return new AtomGenerator(
        new AtomCommonAttributes(parser),
        uri == null ? null : Utils.tryParseUri(uri),
        parser.getAttributeValue(XmlPullParser.NO_NAMESPACE, "uri"),
        parser.nextText());
  }

  public AtomGenerator(@Nullable AtomCommonAttributes atomCommonAttributes, @Nullable URI uri,
                       @Nullable String version, @NonNull String value) {
    super(atomCommonAttributes);
    this.uri = uri;
    this.version = version;
    this.value = value;
  }
}
