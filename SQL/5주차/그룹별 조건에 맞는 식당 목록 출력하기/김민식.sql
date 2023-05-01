SELECT T.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, "%Y-%m-%d") AS REVIEW_DATE
  FROM REST_REVIEW  AS R
  JOIN (
      SELECT M.MEMBER_NAME, M.MEMBER_ID
        FROM MEMBER_PROFILE AS M
        JOIN REST_REVIEW AS R
          ON M.MEMBER_ID = R.MEMBER_ID
       GROUP BY M.MEMBER_ID
       ORDER BY SUM(R.REVIEW_SCORE) DESC
       LIMIT 1) AS T
 WHERE R.MEMBER_ID = T.MEMBER_ID
 ORDER BY R.REVIEW_DATE ASC, R.REVIEW_TEXT ASC