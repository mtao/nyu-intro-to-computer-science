require 'rqrcode_png'
require 'shellwords'
class QrCodeTag < Liquid::Tag
  include Jekyll::LiquidExtensions
  def initialize(tag_name, url, tokens)
    super
    params = Shellwords.shellwords url
    @url = url.strip
  end

  def render(context)
    page_url = Liquid::Template.parse('{{'+@url+'}}').render context

    qr = RQRCode::QRCode.new(page_url, size: 4) # Size increased because URLs can be long
    png = qr.to_img
    png = png.resize(120, 120)
    <<-MARKUP.strip
    <div class="qrcode">
      <a href="#{page_url}" target="_blank"> <img src="#{png.to_data_url}" alt="#{page_url}"> </a>
    </div>
    MARKUP
  end
end

Liquid::Template.register_tag('qr', QrCodeTag)
