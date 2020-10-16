/*** BEGIN META {
  "name" : "Show Windows Agent Versions",
  "comment" : "displays windowns systeminfo for all windows agents.",
  "core": "1.300",
  "authors" : [
    { name : "Gareth Evans" }
  ]
} END META**/
import hudson.util.RemotingDiagnostics;

get_version = 'println "cmd /c systeminfo".execute().text';

def instance = hudson.model.Hudson.instance

instance.slaves.findAll{ s -> s.name.toLowerCase().contains("win") }.each{ slave ->
    println slave.name;
    println RemotingDiagnostics.executeGroovy(get_version, slave.getChannel());
}
