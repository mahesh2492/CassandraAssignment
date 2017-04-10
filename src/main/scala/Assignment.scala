import com.datastax.driver.core.{Session, Cluster}

/**
  * Created by knoldus on 9/4/17.
  */
class Assignment {

  val cluster = Cluster.builder().addContactPoint("0.0.0.0").build()

  val session: Session = cluster.connect("assignment")

  def selectByEmail(email:String) = {
    // session.execute("insert into video(video_name,userid,video_id,year) values('Bahubhali ',1,109,2015);")
    val records = session.execute(s"select * from user where email = '$email' ")
    val iterate = records.iterator()

    while (iterate.hasNext) {

      println(iterate.next())

    }

  }

  def selectByVideoName(videoname:String) = {

    val records = session.execute(s"select * from video where video_name = '$videoname' ")
    val iterate = records.iterator()

    while (iterate.hasNext) {

      println(iterate.next())

    }

  }

  def selectVideoByYear(year:Int) = {

    val records = session.execute(s"select * from videoByYear where year > $year allow filtering")
    val iterate = records.iterator()

    while (iterate.hasNext) {

      println(iterate.next())

    }

  }

  def selectVideoByIdAndYear(userId:Int) = {

    val records = session.execute(s"select * from videoByYear where userId = $userId ORDER BY year DESC LIMIT 5;")
    val iterate = records.iterator()

    while (iterate.hasNext) {

      println(iterate.next())

    }

  }
  //cluster.close()
}
