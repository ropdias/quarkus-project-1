package org.acme.viacep;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class AddressSerializer extends StdSerializer<Address> {
    
  public AddressSerializer() {
      this(null);
  }

  public AddressSerializer(Class<Address> t) {
      super(t);
  }

  @Override
  public void serialize(
    Address value, JsonGenerator jgen, SerializerProvider provider) 
    throws IOException, JsonProcessingException {

      jgen.writeStartObject();
      jgen.writeStringField("cep", value.getCep());
      jgen.writeStringField("nomeDaRua", value.getLogradouro());
      jgen.writeStringField("complemento", value.getComplemento());
      jgen.writeStringField("bairro", value.getBairro());
      jgen.writeStringField("localidade", value.getLocalidade());
      jgen.writeStringField("uf", value.getUf());
      jgen.writeStringField("ibge", value.getIbge());
      jgen.writeStringField("gia", value.getGia());
      jgen.writeStringField("ddd", value.getDdd());
      jgen.writeStringField("siafi", value.getSiafi());
      jgen.writeEndObject();
  }
}
