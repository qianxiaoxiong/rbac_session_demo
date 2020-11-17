public class test {

//    public void getAccessToken2() {
//        try {
//            CloseableHttpClient httpClient = HttpClients.createDefault();
//            HttpPost post = new HttpPost("http://118.244.210.132:80/oauth2/oauth/token?client_id=" +
//                    "8tF0ENiociFc6qJvNOek&client_secret=OSzmSiFDOZ6RdCuuW66D&scope=read&grant_type=client_credentials");
//            post.setHeader("Content-Type", "application/x-www-form-urlencoded");
//            HttpResponse response = httpClient.execute(post);
//            HttpEntity httpEntity = response.getEntity();
//            String responseBody = EntityUtils.toString(httpEntity, "UTF-8");
//            System.out.println("响应报文：" + responseBody);
//            System.out.println("token：" + new JsonParser().parse(responseBody).getAsJsonObject().get("data").
//                    getAsJsonObject().get("access_token").getAsString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
