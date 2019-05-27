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
      <xsl:element name="statistics">
        <xsl:element name="age-stats">
          <young>
            <xsl:value-of select="count(database/data/people/person/birthday[ year-from-date(current-date()) - number(substring(., string-length(.)-4, 80)) &lt;= 25])"/>
          </young>
          <adult>
            <xsl:value-of select="count(database/data/people/person/birthday[ year-from-date(current-date()) - number(substring(., string-length(.)-4, 80)) &gt; 25 
              and year-from-date(current-date()) - number(substring(., string-length(.)-4, 80)) &lt;= 60])"/>
          </adult>
          <old>
            <xsl:value-of select="count(database/data/people/person/birthday[ year-from-date(current-date()) - number(substring(., string-length(.)-4, 80)) &gt; 60])"/>
          </old>
        </xsl:element>
        
        <xsl:element name="bmi-stats">
          <xsl:for-each select="database/data/people/person">
            <person-bmi>
            <name>
            <xsl:value-of select="concat(lastname, ' ', firstname)"/>
            </name>
            <bmi>
              <xsl:variable name="weight" select="physicalcharacteristics/weightinkilograms"/>
              <xsl:variable name="height" select="physicalcharacteristics/growthinmeters"/>
              <xsl:variable name="bmi-value" select="$weight div($height*$height)"/>
              <xsl:value-of select="$bmi-value"/>
              <xsl:if test="$bmi-value &lt; 18.5">
                <weight-rate>
                  underweight
                </weight-rate>
              </xsl:if>
              <xsl:if test="($bmi-value &gt;= 18.5) and ($bmi-value &lt; 24.9)">
                <weight-rate>
                  perfect-weight
                </weight-rate>
              </xsl:if>
              <xsl:if test="($bmi-value &gt;= 24.9) and ($bmi-value &lt; 29.9)">
                <weight-rate>
                  overweight
                </weight-rate>
              </xsl:if>
              <xsl:if test="$bmi-value &gt;= 29.9">
                <weight-rate>
                  obese
                </weight-rate>
              </xsl:if>
            </bmi>
              </person-bmi>
            </xsl:for-each>          
        </xsl:element>
        
        <xsl:element name="card-owners">
          <Visa>
            <xsl:value-of select="count(database/data/creditcards/card[ issuer = 'visa'])"/>
          </Visa>
          <Dinersclubnorthamerica>
            <xsl:value-of select="count(database/data/creditcards/card[ issuer = 'dinersclubnorthamerica'])"/>
          </Dinersclubnorthamerica>
          <Amex>
            <xsl:value-of select="count(database/data/creditcards/card[ issuer = 'amex'])"/>
          </Amex>
          <JCB>
            <xsl:value-of select="count(database/data/creditcards/card[ issuer = 'jcb'])"/>
          </JCB>
          <Laser>
            <xsl:value-of select="count(database/data/creditcards/card[ issuer = 'laser'])"/>
          </Laser>
          <Maestro>
            <xsl:value-of select="count(database/data/creditcards/card[ issuer = 'maestro'])"/>
          </Maestro>
          <Instapayment>
            <xsl:value-of select="count(database/data/creditcards/card[ issuer = 'instapayment'])"/>
          </Instapayment>
          <Visaelectron>
            <xsl:value-of select="count(database/data/creditcards/card[ issuer = 'visaelectron'])"/>
          </Visaelectron>
          <Discover>
            <xsl:value-of select="count(database/data/creditcards/card[ issuer = 'discover'])"/>
          </Discover>
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
