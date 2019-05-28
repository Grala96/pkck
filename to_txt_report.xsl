<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
   <xsl:output method="text" encoding="UTF-16" indent="yes" />
   <xsl:strip-space elements="*" />
   <xsl:template match="/">
      <xsl:text>=====================================================</xsl:text>
      <xsl:text>Person List</xsl:text>
      <xsl:text>=====================================================</xsl:text>
      <xsl:for-each select="root/personal-data/person">
         <xsl:call-template name="line">
            <xsl:with-param name="label" select="'Name:'" />
            <xsl:with-param name="value" select="normalize-space(name)" />
         </xsl:call-template>
         <xsl:call-template name="line">
            <xsl:with-param name="label" select="'Birthday:'" />
            <xsl:with-param name="value" select="normalize-space(birthday)" />
         </xsl:call-template>
         <xsl:call-template name="line">
            <xsl:with-param name="label" select="'Country:'" />
            <xsl:with-param name="value" select="normalize-space(country)" />
         </xsl:call-template>
         <xsl:call-template name="line">
            <xsl:with-param name="label" select="'City:'" />
            <xsl:with-param name="value" select="normalize-space(city)" />
         </xsl:call-template>
         <xsl:call-template name="line">
            <xsl:with-param name="label" select="'Company:'" />
            <xsl:with-param name="value" select="normalize-space(work/company)" />
         </xsl:call-template>
         <xsl:text>-----------------------------------------------------</xsl:text>
      </xsl:for-each>
      <xsl:text>=====================================================</xsl:text>
      <xsl:text>BMI Statistics</xsl:text>
      <xsl:text>=====================================================</xsl:text>
      <xsl:for-each select="/root/statistics/bmi-stats/person-bmi">
         <xsl:call-template name="line">
            <xsl:with-param name="label" select="'Name:'" />
            <xsl:with-param name="value" select="normalize-space(name)" />
         </xsl:call-template>
         <xsl:call-template name="line">
            <xsl:with-param name="label" select="'BMI:'" />
            <xsl:with-param name="value" select="normalize-space(bmi/text())" />
         </xsl:call-template>
         <xsl:call-template name="line">
            <xsl:with-param name="label" select="'Weight Rate:'" />
            <xsl:with-param name="value" select="normalize-space(translate(bmi/weight-rate/text(), ' ',''))" />
         </xsl:call-template>
         <xsl:text>-----------------------------------------------------</xsl:text>
      </xsl:for-each>
      <xsl:text>=====================================================</xsl:text>
      <xsl:text>Age Statistics</xsl:text>
      <xsl:text>=====================================================</xsl:text>
      <xsl:for-each select="/root/statistics/age-stats/*">
         <xsl:call-template name="line">
            <xsl:with-param name="label" select="'Name:'" />
            <xsl:with-param name="value" select="normalize-space(local-name())" />
         </xsl:call-template>
         <xsl:call-template name="line">
            <xsl:with-param name="label" select="'Quantity:'" />
            <xsl:with-param name="value" select="normalize-space(.)" />
         </xsl:call-template>
         <xsl:text>-----------------------------------------------------</xsl:text>
      </xsl:for-each>
      <xsl:text>=====================================================</xsl:text>
      <xsl:text>Card Owners</xsl:text>
      <xsl:text>=====================================================</xsl:text>
      <xsl:for-each select="/root/statistics/card-owners/*">
         <xsl:call-template name="line">
            <xsl:with-param name="label" select="'Card:'" />
            <xsl:with-param name="value" select="normalize-space(local-name())" />
         </xsl:call-template>
         <xsl:call-template name="line">
            <xsl:with-param name="label" select="'Quantity:'" />
            <xsl:with-param name="value" select="normalize-space(.)" />
         </xsl:call-template>
         <xsl:text>-----------------------------------------------------</xsl:text>
      </xsl:for-each>
      <xsl:text>=====================================================</xsl:text>
      <xsl:text>Administrators</xsl:text>
      <xsl:text>=====================================================</xsl:text>
      <xsl:for-each select="/root/administrators/*[name()!='copyright']">
         <xsl:call-template name="line">
            <xsl:with-param name="label" select="'Name:'" />
            <xsl:with-param name="value" select="normalize-space(substring(text(),2,(string-length(text())-2)))" />
         </xsl:call-template>
         <xsl:call-template name="line">
            <xsl:with-param name="label" select="'Index:'" />
            <xsl:with-param name="value" select="normalize-space(index)" />
         </xsl:call-template>
         <xsl:text>-----------------------------------------------------</xsl:text>
      </xsl:for-each>
   </xsl:template>
   <xsl:template name="line">
      <xsl:param name="label" />
      <xsl:param name="value" />
      <xsl:variable name="lineding" select="'                                                     '" />
      <xsl:value-of select="concat($label,substring($lineding,string-length($label) +1+ string-length($value)),$value,'&#xA;')" disable-output-escaping="yes" />
   </xsl:template>
</xsl:stylesheet>
