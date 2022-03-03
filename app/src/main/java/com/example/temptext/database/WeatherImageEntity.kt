package com.example.temptext.database


@Entity (tableName = "WeatherImages")
data class WeatherImageEntity(
    @PrimaryKey(autoGenerate = true)
    @Transient
    @ColumnInfo (name = "id")
    val id : Int? = null,

    @Json (name = "message")
     @ColumnInfo ( name = "image_url")
     val message : String


     @Json ( name = "status")@
      @ColumnInfo (name = "status")
       val statusResponse : String,

)
