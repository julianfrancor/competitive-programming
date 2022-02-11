SELECT
    merchantName,
    hashedShopperReference,
    ROUND(AVG(riskScore), 2)  AS averageRiskScore,
    count(hashedShopperReference)
FROM merchant JOIN transaction ON merchant.merchantId=transaction.merchantId
GROUP BY merchantName, hashedShopperReference
ORDER BY merchantName ASC, averageRiskScore DESC