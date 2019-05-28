<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" version="1.0">
   <xsl:output method="xml" indent="yes" encoding="iso-8859-1" />
   <xsl:template match="/">
      <fo:root>
         <fo:layout-master-set>
            <fo:simple-page-master master-name="A4" page-height="11in" page-width="8.5in" margin-top=".5in" margin-bottom=".5in" margin-left=".5in" margin-right=".5in">
               <fo:region-body margin-top="1in" margin-bottom="1in" />
               <fo:region-before extent=".5in" />
               <fo:region-after extent=".5in" />
            </fo:simple-page-master>
         </fo:layout-master-set>
         <fo:page-sequence master-reference="A4">
            <fo:static-content flow-name="xsl-region-before" text-align="center">
               <fo:block font-size="20pt" font-weight="bold">Personal Database</fo:block>
            </fo:static-content>
            <fo:flow flow-name="xsl-region-body">
               <fo:block text-align="center" margin="10px">Person List</fo:block>
               <fo:table table-layout="fixed" border-width="1mm" border-style="solid" font-size="8px" break-after="page">
                  <fo:table-column column-width="120px" />
                  <fo:table-column />
                  <fo:table-column />
                  <fo:table-column />
                  <fo:table-column column-width="150px" />
                  <fo:table-header text-align="center" background-color="silver">
                     <fo:table-row>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">Name</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">Birthday</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">Country</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">City</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">Company</fo:block>
                        </fo:table-cell>
                     </fo:table-row>
                  </fo:table-header>
                  <fo:table-body>
                     <xsl:for-each select="/root/personal-data/person">
                        <fo:table-row>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="name" />
                              </fo:block>
                           </fo:table-cell>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="birthday" />
                              </fo:block>
                           </fo:table-cell>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="country" />
                              </fo:block>
                           </fo:table-cell>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="city" />
                              </fo:block>
                           </fo:table-cell>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="work/company" />
                              </fo:block>
                           </fo:table-cell>
                        </fo:table-row>
                     </xsl:for-each>
                  </fo:table-body>
               </fo:table>
               <fo:block text-align="center" margin="10px">BMI Statistics</fo:block>
               <fo:table table-layout="fixed" border-width="1mm" border-style="solid" font-size="10px" break-after="page">
                  <fo:table-column />
                  <fo:table-column />
                  <fo:table-column />
                  <fo:table-header text-align="center" background-color="silver">
                     <fo:table-row>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">Name</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">BMI</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">Weight Rate</fo:block>
                        </fo:table-cell>
                     </fo:table-row>
                  </fo:table-header>
                  <fo:table-body>
                     <xsl:for-each select="/root/statistics/bmi-stats/person-bmi">
                        <fo:table-row>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="name" />
                              </fo:block>
                           </fo:table-cell>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="bmi/text()" />
                              </fo:block>
                           </fo:table-cell>
                           <fo:table-cell padding="2px">
                              <fo:block text-align="center">
                                 <xsl:value-of select="translate(bmi/weight-rate/text(), ' ','')" />
                              </fo:block>
                           </fo:table-cell>
                        </fo:table-row>
                     </xsl:for-each>
                  </fo:table-body>
               </fo:table>
               <fo:block text-align="center" margin="10px">Age Statistics</fo:block>
               <fo:table table-layout="fixed" border-width="1mm" border-style="solid" font-size="10px" text-align="center">
                  <fo:table-column />
                  <fo:table-column />
                  <fo:table-header text-align="center" background-color="silver">
                     <fo:table-row>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">Name</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">Quantity</fo:block>
                        </fo:table-cell>
                     </fo:table-row>
                  </fo:table-header>
                  <fo:table-body>
                     <xsl:for-each select="/root/statistics/age-stats/*">
                        <fo:table-row>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="local-name()" />
                              </fo:block>
                           </fo:table-cell>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="." />
                              </fo:block>
                           </fo:table-cell>
                        </fo:table-row>
                     </xsl:for-each>
                  </fo:table-body>
               </fo:table>
               <fo:block text-align="center" margin="10px">Card Owners</fo:block>
               <fo:table table-layout="fixed" border-width="1mm" border-style="solid" font-size="10px" text-align="center">
                  <fo:table-column />
                  <fo:table-column />
                  <fo:table-header text-align="center" background-color="silver">
                     <fo:table-row>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">Card</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">Quantity</fo:block>
                        </fo:table-cell>
                     </fo:table-row>
                  </fo:table-header>
                  <fo:table-body>
                     <xsl:for-each select="/root/statistics/card-owners/*">
                        <fo:table-row>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="local-name()" />
                              </fo:block>
                           </fo:table-cell>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="." />
                              </fo:block>
                           </fo:table-cell>
                        </fo:table-row>
                     </xsl:for-each>
                  </fo:table-body>
               </fo:table>
               <fo:block text-align="center" margin="10px">Administrators</fo:block>
               <fo:table table-layout="fixed" border-width="1mm" border-style="solid" font-size="10px" text-align="center">
                  <fo:table-column />
                  <fo:table-column />
                  <fo:table-header text-align="center" background-color="silver">
                     <fo:table-row>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">Name</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="1mm" border-width="1mm" border-style="solid">
                           <fo:block font-weight="bold">Index</fo:block>
                        </fo:table-cell>
                     </fo:table-row>
                  </fo:table-header>
                  <fo:table-body>
                     <xsl:for-each select="/root/administrators/*[name()!='copyright']">
                        <fo:table-row>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="substring(text(),2,(string-length(text())-2))" />
                              </fo:block>
                           </fo:table-cell>
                           <fo:table-cell padding="2px">
                              <fo:block>
                                 <xsl:value-of select="index" />
                              </fo:block>
                           </fo:table-cell>
                        </fo:table-row>
                     </xsl:for-each>
                  </fo:table-body>
               </fo:table>
            </fo:flow>
         </fo:page-sequence>
      </fo:root>
   </xsl:template>
</xsl:stylesheet>
