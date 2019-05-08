<?xml version = "1.0" encoding = "UTF-8"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:key name="house_key" match="//data/houses/house" use="@houseid"/>
  <xsl:key name="person_house_key" match="//data/people/person" use="@house"/>
  <xsl:key name="work_key" match="//data/business/company" use="@companyid"/>

  <xsl:template match="/">
    <xsl:element name="root">
      <xsl:element name="personal-data">
        <xsl:apply-templates select="database/data"/>
        <xsl:apply-templates select="database/data/people/person"/>
        <xsl:apply-templates select="data/people/person/birthday"/>
      </xsl:element>
      <xsl:element name="satatistics">
        <xsl:element name="age-statistics">
          <young>
            <xsl:value-of select="count(database/data/people/person/birthday[ year-from-date(current-date()) - number(substring(., string-length(.)-4, 80)) &lt;= 25])"/>
          </young>
          <adult>
            <xsl:value-of select="count((database/data/people/person/birthday[ year-from-date(current-date()) - number(substring(., string-length(.)-4, 80)) &gt; 25])
              and (database/data/people/person/birthday[ year-from-date(current-date()) - number(substring(., string-length(.)-4, 80)) &lt;= 60]))"/>
          </adult>
          <old>
            <xsl:value-of select="count(database/data/people/person/birthday[ year-from-date(current-date()) - number(substring(., string-length(.)-4, 80)) &gt; 60])"/>
          </old>
        </xsl:element>
      </xsl:element>
      <xsl:copy-of select="database/administrators"/>
    </xsl:element>
  </xsl:template>

  <xsl:template match="data"> </xsl:template>

  <xsl:template match="person">
    <xsl:element name="person">
      <xsl:element name="name">
        <xsl:value-of select="concat(lastname, ' ', firstname, ' ', middlename)"/>
      </xsl:element>
      <xsl:element name="birthday">
        <xsl:value-of select="birthday"/>
      </xsl:element>

      <xsl:for-each select="key('house_key', @house)">
        <xsl:element name="country">
          <xsl:value-of select="address/country"/>
        </xsl:element>
        <xsl:element name="city">
          <xsl:value-of select="address/city"/>
        </xsl:element>
      </xsl:for-each>

      <xsl:element name="work">
        <xsl:for-each select="key('work_key', work/@companyid)">
          <xsl:element name="company">
            <xsl:value-of select="companyname"/>
          </xsl:element>
          <xsl:element name="position">
            <xsl:value-of select="work/position"/>
          </xsl:element>
        </xsl:for-each>
      </xsl:element>

    </xsl:element>
  </xsl:template>

  <xsl:template match="database/administrators">
    <xsl:element name="aa">
      <xsl:copy-of select="admin"/>
    </xsl:element>
    <xsl:apply-templates/>
  </xsl:template>


</xsl:stylesheet>
