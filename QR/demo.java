

public static List<String> readQRCodeFromPDF(File pdfFile) throws IOExecption
{
    List<String> qrCodeTexts = new ArrayList<>();
    if(pdfFile != null && pdfFile.exists())
    {
        try(PDDocument document = Loader.loadPDF(pdfFile)){
            PDFRendered rendered =  new PDFRendered(document);
            for(int i =0; i < document.getNumberOfPages(); i++)
            {
                // Bug ở đây
                BufferredImage bufferredImage = rendered.renderImage(i, 300, ImageType.RGB);

                try(ByteArrayOutputStream.outoutStream =  new ByteArrayOutputStream()){
                    ImageIO.write(bufferredImage, "png", outoutStream);
                    outoutStream.flush();
                    byte[] imageByte =  outoutStream.toByteArray();

                    String qrcode = readQRCodeFromImage(imageByte);
                    if(qrcode != null && !qrcode.isEmpty())
                    {
                        qrCodeTexts.add(qrcode);
                    }
                }
                bufferredImage.flush();
            }
        }
    }
    return qrCodeTexts;
}


public String readQRCodeFromImage(byte[] imageByte) throws IOExecption
{
    BufferredImage bufferredImage  = ImageIO.read(new HybridBinarizer(
        new BufferredImageLuminanceSource(bufferredImage)
    ));
    try{
        Result result = new MultiFormatReader().decode(binaryBitmap);
        return result.getText();
    } catch(NotFoundException e){
        return null;
    }
}